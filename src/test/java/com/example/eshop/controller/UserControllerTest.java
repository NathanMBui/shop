package com.example.eshop.controller;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUserById() throws Exception {
        //given
        given(userService.getUserById(anyLong())).willReturn(Optional.of(
                        UserDTO.builder()
                                .id(1L)
                                .firstName("Tony")
                                .lastName("Stark")
                                .build())
        );

        //when
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("firstName").value("Tony"))
                .andExpect(jsonPath("lastName").value("Stark"));

    }

    @Test
    public void testGetUserById_throwNotFound() throws Exception {
        //given
        given(userService.getUserById(anyLong())).willReturn(Optional.empty());

        //when then
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound());
    }
}
