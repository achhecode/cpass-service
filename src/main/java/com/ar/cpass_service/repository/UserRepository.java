package com.ar.cpass_service.repository;


import com.ar.cpass_service.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserEntity> getAllUserDetails();

    @Transactional
    @Query(value = "SELECT * FROM users WHERE USERNAME=:username LIMIT 1", nativeQuery = true)
    UserEntity getUserDetails(@Param("username") String username);


    // .save(T) will do the same job
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (username, name, age, role, address) VALUES (:username, :name, :age, :role, :address)", nativeQuery = true)
    int insertUser(@Param("username") String username, @Param("name") String name, @Param("age") int age, @Param("role") String role, @Param("address") String address);

}
