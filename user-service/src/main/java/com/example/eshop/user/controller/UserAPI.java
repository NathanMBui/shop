package com.example.eshop.user.controller;

import com.example.eshop.user.data.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserAPI {
    Page<UserDTO> getUsersPaginate(Pageable pageable);
    List<UserDTO> searchUsers(String firstName, String lastName);
    UserDTO getUser(@PathVariable("id") long id);
}
