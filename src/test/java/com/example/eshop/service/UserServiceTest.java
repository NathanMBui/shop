package com.example.eshop.service;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.UserEntity;
import com.example.eshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
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
        UserEntity user = new UserEntity();
        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        //when
        Optional<UserDTO> optUser = userService.getUserById(0L);

        //then
        then(optUser).isNotNull();
        then(optUser.get().getId()).isEqualTo(0L);
    }
}
