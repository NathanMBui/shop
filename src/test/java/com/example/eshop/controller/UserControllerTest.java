package com.example.eshop.controller;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.UserEntity;
import com.example.eshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

    @Test
    public void testGetAllUsersWithPageable() throws Exception {
        //given
        int totalUser = 2;
        ArrayList<UserDTO> userList = new ArrayList<>();
        for (int i = 0; i < totalUser; i++) {
            userList.add(new UserDTO());
        }
        Pageable pageable = Pageable.ofSize(2).withPage(1);
        Page<UserDTO> userPage = new PageImpl<>(userList, pageable, 10);
        given(userService.getUsers(any(Pageable.class))).willReturn(userPage);

        //when then
        mockMvc.perform(get("/users?page=0&size=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andDo(print());
    }
}
