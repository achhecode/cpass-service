package com.ar.cpass_service.serviceimpl;

import com.ar.cpass_service.entity.UserDataDocument;
import com.ar.cpass_service.model.UserDataDTO;
import com.ar.cpass_service.repository.UserDataRepository;
import com.ar.cpass_service.service.UserDataService;
import com.ar.cpass_service.util.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public List<UserDataDTO> getAllUsers() {
        List<UserDataDocument> documents = userDataRepository.findAll();
        return documents.stream()
                .map(UserDataMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDataDTO getUserByUsername(String username) {
//        Optional<UserDataDocument> document = userDataRepository
//                .findAll()
//                .stream()
//                .filter(user -> user.getUsername().equalsIgnoreCase(username))
//                .findFirst();
//
//        return document.map(UserDataMapper::toDTO).orElse(null);

        return userDataRepository.findByUsername(username)
                .map(UserDataMapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserDataDTO addUser(UserDataDTO user) {
        UserDataDocument document = UserDataMapper.toDocument(user);
        UserDataDocument saved = userDataRepository.save(document);
        return UserDataMapper.toDTO(saved);
    }

    @Override
    public List<UserDataDTO> addUsers(List<UserDataDTO> users) {
        List<UserDataDocument> documents = users.stream()
                .map(UserDataMapper::toDocument)
                .collect(Collectors.toList());

        List<UserDataDocument> savedDocs = userDataRepository.saveAll(documents);
        return savedDocs.stream()
                .map(UserDataMapper::toDTO)
                .collect(Collectors.toList());
    }
}