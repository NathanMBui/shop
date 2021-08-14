package com.example.eshop.repository;

import com.example.eshop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
}
