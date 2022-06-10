package com.alamin.converter;

import com.alamin.dto.UserDto;
import com.alamin.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDto entityToDto(User user){
        return new ModelMapper().map(user, UserDto.class);
    }


    public List<UserDto> entityToDto(List<User> users) {
        return	users.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public User dtoToEntity(UserDto userDto){
        return new ModelMapper().map(userDto, User.class);
    }

    public List<User> dtoToEntity(List<UserDto> usersDto) {
        return	usersDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
