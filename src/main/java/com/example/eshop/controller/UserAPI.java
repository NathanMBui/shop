package com.example.eshop.controller;

import com.example.eshop.data.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserAPI {
    Authentication signin(String username, String password);
    UserDTO signup(@RequestBody UserDTO userInfo);
    Page<UserDTO> getUsersPaginate(Pageable pageable);
    List<UserDTO> searchUsers(String firstName, String lastName);
    UserDTO getUser(@PathVariable("id") long id);
}
