package com.ar.cpass_service.repository;

import com.ar.cpass_service.entity.UserDataDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDataRepository extends MongoRepository<UserDataDocument, String> {
    Optional<UserDataDocument> findByUsername(String username);
}
