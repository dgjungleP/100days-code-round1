package com.jungle.challenge.plugins.desensitization;

public class PhoneDesensitizeStrategy implements DesensitizeStrategy<String, String> {

    @Override
    public String doDesensitize(String data) {
        return data.replaceAll("(\\d{3})\\d{4}(\\d+)", "$1****$2");
    }

}
