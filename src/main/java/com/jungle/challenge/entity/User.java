package com.jungle.challenge.entity;

import com.jungle.challenge.plugins.desensitization.Desensitized;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    @Desensitized()
    private String userPhone;
}
