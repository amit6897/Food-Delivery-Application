package com.example.userinfo.service;

import com.example.userinfo.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDto addUser(UserDto userDto);


    ResponseEntity<UserDto> fetchUserDetailsById(Integer userId);
}
