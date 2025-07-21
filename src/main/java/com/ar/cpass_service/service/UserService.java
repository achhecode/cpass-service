package com.ar.cpass_service.service;

import com.ar.cpass_service.model.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUserDetails();
    UserDTO getUserDetails(String username);
    UserDTO insertUserDetails(UserDTO user);
    List<UserDTO> insertAllUserDetails(List<UserDTO> users);
}
