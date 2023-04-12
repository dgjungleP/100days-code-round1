package com.jungle.challenge.plugins;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Desensitized {

    Class<?> staticConstructor() default DefaultDesensitizeStrategy.class;
}
