package com.example.eshop.repository;

import com.example.eshop.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByFirstName(String firstName);
    Optional<UserEntity> findByLastName(String lastName);
    List<UserEntity> findByFirstNameOrLastName(String firstName, String lastName);
}
