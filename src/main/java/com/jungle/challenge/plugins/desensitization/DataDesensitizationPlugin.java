package com.jungle.challenge.plugins.desensitization;

import com.jungle.challenge.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;


@Intercepts({@Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = {Statement.class}
)})
@Slf4j
public class DataDesensitizationPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        Class<?> resultClass = proceed.getClass();
        if (Collection.class.isAssignableFrom(resultClass)) {
            Collection<?> result = (Collection<?>) proceed;
            if (result.isEmpty()) {
                return result;
            }
            Class<?> resultMapClazz = result.stream().findFirst().get().getClass();
            result.forEach(data -> doDesensitize(resultMapClazz, data));
        } else {
            doDesensitize(resultClass, proceed);
        }
        return proceed;
    }

    private void doDesensitize(Class<?> resultMapClazz, Object data) {
        List<Field> desensitizedFields = ClassUtil
                .filterFieldList(Arrays.asList(resultMapClazz.getDeclaredFields()), Desensitized.class);
        if (desensitizedFields.isEmpty()) {
            return;
        }

        for (Field field : desensitizedFields) {
            try {
                Method getMethod = ClassUtil.getMethod(resultMapClazz, ClassUtil.MethodTYpe.GET, field);
                Object value = getMethod.invoke(data);
                if (value == null) {
                    continue;
                }
                Method setMethod = ClassUtil.getMethod(resultMapClazz, ClassUtil.MethodTYpe.SET, field);

                Desensitized annotation = field.getAnnotation(Desensitized.class);
                Class<?> strategy = annotation.strategy();
                DesensitizeStrategy desensitizeStrategy = (DesensitizeStrategy) strategy.newInstance();
                setMethod.invoke(data, desensitizeStrategy.doDesensitize(value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


