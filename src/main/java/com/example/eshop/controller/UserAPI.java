package com.example.eshop.controller;

import com.example.eshop.data.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserAPI {
    Page<UserDTO> getUsersPaginate(Pageable pageable);
    List<UserDTO> searchUsers(String firstName, String lastName);
    UserDTO getUser(@PathVariable("id") long id);
    public UserDTO createUser(@RequestBody UserDTO userDTO);
}
