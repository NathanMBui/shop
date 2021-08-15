package com.example.eshop.data;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper {
    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);
}
