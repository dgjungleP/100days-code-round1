package com.jungle.challenge.plugins.desensitization;

public interface DesensitizeStrategy<T, R> {

    R doDesensitize(T data);
}
