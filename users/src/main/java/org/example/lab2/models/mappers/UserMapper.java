package org.example.lab2.models.mappers;


import org.example.lab2.models.dtos.UserDto;
import org.example.lab2.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name",target = "name")
    @Mapping(source = "email",target="email")
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);
}
