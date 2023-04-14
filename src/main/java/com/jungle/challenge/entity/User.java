package com.jungle.challenge.entity;

import com.jungle.challenge.plugins.desensitization.Desensitized;
import com.jungle.challenge.plugins.desensitization.PhoneDesensitizeStrategy;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    @Desensitized(strategy = PhoneDesensitizeStrategy.class)
    private String userPhone;
}
