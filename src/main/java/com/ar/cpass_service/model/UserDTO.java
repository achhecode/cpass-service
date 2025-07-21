package com.ar.cpass_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String username;
    private String name;
    private int age;
    private String role;
    private String address;
}
