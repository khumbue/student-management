package com.ultech.service;

import com.ultech.exceptions.UserException;
import com.ultech.model.User;
import com.ultech.model.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user) throws UserException;
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
