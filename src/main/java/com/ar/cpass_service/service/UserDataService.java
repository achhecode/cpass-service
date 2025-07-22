package com.ar.cpass_service.service;

import com.ar.cpass_service.model.UserDataDTO;

import java.util.List;

public interface UserDataService {
    List<UserDataDTO> getAllUsers();
    UserDataDTO getUserByUsername(String username);
    UserDataDTO addUser(UserDataDTO user);
    List<UserDataDTO> addUsers(List<UserDataDTO> user);
}
