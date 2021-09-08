package com.example.eshop.user.data;

import com.example.eshop.user.data.dto.UserDTO;
import com.example.eshop.user.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper {
    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);


}
