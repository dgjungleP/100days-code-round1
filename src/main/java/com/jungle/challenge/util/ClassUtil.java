package com.jungle.challenge.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassUtil {

    public static Method getMethod(Class<?> clazz, MethodTYpe type, Field field) throws Exception {
        String name = field.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        name = type.name().toLowerCase() + name;
        return type.equals(MethodTYpe.GET) ?
                clazz.getDeclaredMethod(name) :
                clazz.getDeclaredMethod(name, field.getType());
    }

    public static List<Field> filterFieldList(List<Field> fieldList, Class<?> annotationType) {
        return fieldList.stream()
                .filter(field -> Arrays.stream(field.getAnnotations())
                        .anyMatch(annotation -> annotation.annotationType().equals(annotationType)))
                .collect(Collectors.toList());

    }

    public enum MethodTYpe {
        GET, SET
    }

}
