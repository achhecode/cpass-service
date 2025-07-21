package com.ar.cpass_service.serviceimpl;

import com.ar.cpass_service.entity.UserEntity;
import com.ar.cpass_service.model.UserDTO;
import com.ar.cpass_service.repository.UserRepository;
import com.ar.cpass_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUserDetails() {
        List<UserEntity> users = userRepository.getAllUserDetails();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserDetails(String username) {
        UserEntity user = userRepository.getUserDetails(username);
        return (user != null) ? convertToDTO(user) : null;
    }

    @Override
    public UserDTO insertUserDetails(UserDTO user) {
        UserEntity userEntity = convertToEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);  // capture returned entity
        return convertToDTO(savedEntity);
    }

    @Override
    public List<UserDTO> insertAllUserDetails(List<UserDTO> users) {
        List<UserEntity> entities = users.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        List<UserEntity> savedEntities = (List<UserEntity>) userRepository.saveAll(entities);

        return savedEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(UserEntity user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getName(), user.getAge(), user.getRole(), user.getAddress());
    }

    private UserEntity convertToEntity(UserDTO user) {
        return new UserEntity(user.getUsername(), user.getName(), user.getAge(), user.getRole(), user.getAddress());
    }
}
