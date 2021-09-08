package com.example.eshop.controller;

import com.example.eshop.connector.UserServiceConnector;
import com.example.eshop.data.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserAPI {

    Authentication signin(String username, String password);

    UserDTO signup(@RequestBody UserDTO userInfo);

    Page<UserDTO> getUsersPaginate(Pageable pageable);

    List<UserDTO> searchUsers(String firstName, String lastName);

    @GetMapping
    @Operation(summary = "login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "login success",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404", description = "user not exists",
            content = @Content)
    })
    UserDTO getUser(@PathVariable("id") long id);
}
