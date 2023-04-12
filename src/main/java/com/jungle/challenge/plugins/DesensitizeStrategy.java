package com.jungle.challenge.plugins;

public interface DesensitizeStrategy<T, R> {

    R doDesensitize(T data);
}
