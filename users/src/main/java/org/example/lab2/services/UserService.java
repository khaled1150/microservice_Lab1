package org.example.lab2.services;


import org.example.lab2.models.dtos.UserDto;
import org.example.lab2.models.entities.User;
import org.example.lab2.models.mappers.UserMapper;
import org.example.lab2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserMapper userMapper;
    public UserDto findUserById(Integer id) {
        User user= userRepo.findById(id).get();
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return userMapper.toUserDto(user);
    }
    public void save(User user) {
        userRepo.save(user);
    }
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return userMapper.toUserDtoList(users);
    }
}
