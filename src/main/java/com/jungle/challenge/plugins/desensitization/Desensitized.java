package com.jungle.challenge.plugins.desensitization;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Desensitized {

    Class<? extends DesensitizeStrategy> strategy() default DefaultDesensitizeStrategy.class;
}
