package com.ar.cpass_service.controller;

import com.ar.cpass_service.model.UserDTO;
import com.ar.cpass_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all-details")
    public ResponseEntity<List<UserDTO>> getAllUserDetails() {
        log.info("Retrieving all user details");
        List<UserDTO> users = userService.getAllUserDetails();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content if list is empty
        }
        return ResponseEntity.ok(users);  // 200 OK with user list
    }

    @GetMapping("/details")
    public ResponseEntity<UserDTO> getUserDetails(@RequestParam String username) {
        log.info("Retrieving user details for username: {}", username);

        if (username == null || username.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();  // 400 Bad Request for invalid param
        }

        UserDTO user = userService.getUserDetails(username);
        if (user == null) {
            return ResponseEntity.notFound().build();  // 404 Not Found if user doesn't exist
        }

        return ResponseEntity.ok(user);  // 200 OK with user data
    }


    @PostMapping("/add-user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
        UserDTO saved = userService.insertUserDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);  // 201 Created
    }

    @PostMapping("/add-users")
    public ResponseEntity<List<UserDTO>> addUsers(@RequestBody List<UserDTO> users) {
        List<UserDTO> saved = userService.insertAllUserDetails(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);  // 201 Created
    }
}
