package com.example.eshop.user.controller;

import com.example.eshop.user.data.dto.UserDTO;
import com.example.eshop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "users")
@Slf4j
public class UserController extends ControllerBase implements UserAPI {

    @Autowired
    private UserService userService;

    @GetMapping("")
    @Override
    public Page<UserDTO> getUsersPaginate(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsers(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String lastName) {
        return userService.searchUsers(firstName, lastName);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") long id) {
        return userService.getUserById(id).orElseThrow();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String error404(NoSuchElementException ex) {
        return "User not found";
    }
}
