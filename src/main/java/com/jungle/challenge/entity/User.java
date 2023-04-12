package com.jungle.challenge.entity;

import com.jungle.challenge.plugins.Desensitized;
import lombok.Data;

@Data
public class User {
    private Long id;
    @Desensitized
    private String userName;
}
