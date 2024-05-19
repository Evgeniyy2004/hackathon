package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String password;
    private String email;
    private String phone;
}
