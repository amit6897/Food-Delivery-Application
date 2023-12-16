package com.example.userinfo.service;

import com.example.userinfo.dto.UserDto;
import com.example.userinfo.entity.User;
import com.example.userinfo.mapper.UserMapper;
import com.example.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    @Override
    public ResponseEntity<UserDto> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        return fetchedUser.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(user),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        /**
         * if (fetchedUser.isPresent()) {
         *      return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(fetchedUser.get()), HttpStatus.OK);
         * }
         * return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         */
    }
}
