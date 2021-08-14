package com.example.eshop.service;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.User;
import com.example.eshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testGetUserById() {
        //given
        User user = new User();
        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        //when
        Optional<UserDTO> optUser = userService.getUserById(0L);

        //then
        then(optUser).isNotNull();
        then(optUser.get().getId()).isEqualTo(0L);
    }

    @Test
    public void testGetAllUserWithPaging() {
        //given
        int totalUser = 10;
        int pageSize = 5;
        int testingPage = 0;
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < totalUser; i++) {
            userList.add(new User());
        }
        Pageable pageable = Pageable.ofSize(pageSize).withPage(testingPage);
        Page<User> userEntityPage = new PageImpl<>(userList, pageable, totalUser);
        given(userRepository.findAll(any(Pageable.class))).willReturn(userEntityPage);

        //when
        Page<UserDTO> returnedPage = userService.getUsers(pageable);

        //then
        then(returnedPage).isNotNull();
        then(returnedPage.getTotalPages()).isEqualTo(2);
        then(returnedPage.getTotalElements()).isEqualTo(totalUser);
    }
}
