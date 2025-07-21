package com.ar.cpass_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private int age;
    private String role;
    private String address;

    public UserEntity(String username, String name, int age, String role, String address) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.role = role;
        this.address = address;
    }
}