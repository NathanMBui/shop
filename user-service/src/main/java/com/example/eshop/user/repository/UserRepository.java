package com.example.eshop.user.repository;

import com.example.eshop.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmailOrMobile(String email, String mobile);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
}
