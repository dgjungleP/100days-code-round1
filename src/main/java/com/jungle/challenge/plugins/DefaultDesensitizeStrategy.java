package com.jungle.challenge.plugins;

public class DefaultDesensitizeStrategy implements DesensitizeStrategy<String, String> {
    @Override
    public String doDesensitize(String data) {
        return data;
    }
}
