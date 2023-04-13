package com.jungle.challenge.plugins.desensitization;

import lombok.Data;

@Data
public class DefaultDesensitizeStrategy implements DesensitizeStrategy<String, String> {
    @Override
    public String doDesensitize(String data) {
        return data + "test";
    }
}
