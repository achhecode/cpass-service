package com.ar.cpass_service.controller;

import com.ar.cpass_service.model.UserDataDTO;
import com.ar.cpass_service.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/all")
    public List<UserDataDTO> getAllUsers() {
        return userDataService.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserDataDTO getUser(@PathVariable String username) {
        return userDataService.getUserByUsername(username);
    }

    @PostMapping("/add")
    public UserDataDTO addUser(@RequestBody UserDataDTO dto) {
        return userDataService.addUser(dto);
    }

    @PostMapping("/add-batch")
    public List<UserDataDTO> addUsers(@RequestBody List<UserDataDTO> dtos) {
        return userDataService.addUsers(dtos);
    }
}