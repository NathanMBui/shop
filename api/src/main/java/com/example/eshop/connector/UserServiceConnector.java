package com.example.eshop.connector;

import com.example.eshop.data.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceConnector {
    @GetMapping("users")
    Page<UserDTO> getUsersPaginate(Pageable pageable);
    @GetMapping("users/search")
    List<UserDTO> searchUsers(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);
    @GetMapping("users/${id}")
    UserDTO getUser(@PathVariable("id") long id);
}
