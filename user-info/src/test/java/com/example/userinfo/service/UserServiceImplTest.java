package com.example.userinfo.service;

import com.example.userinfo.dto.UserDto;
import com.example.userinfo.entity.User;
import com.example.userinfo.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * @BeforeEach
     * void setUp() {
     *      MockitoAnnotations.openMocks(this);
     * }
     */

    @Test
    void testAddUser() {
        // Arrange
        UserDto userDto = new UserDto();
        User user = new User();
        when(userRepo.save(any())).thenReturn(user);

        // Act
        UserDto result = userService.addUser(userDto);

        // Assert
        assertEquals(userDto, result);
        verify(userRepo, times(1)).save(any());
    }

    @Test
    void testFetchUserDetailsById_UserExists() {
        // Arrange
        Integer userId = 1;
        User user = new User();
        user.setUserId(userId);
        when(userRepo.findById(userId)).thenReturn(Optional.of(user));

        // Act
        ResponseEntity<UserDto> result = userService.fetchUserDetailsById(userId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(userId, Objects.requireNonNull(result.getBody()).getUserId());
        //assertEquals(userId, result.getBody().getUserId());
        verify(userRepo, times(1)).findById(userId);
    }

    @Test
    void testFetchUserDetailsById_UserNotFound() {
        // Arrange
        Integer userId = 1;
        when(userRepo.findById(userId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<UserDto> result = userService.fetchUserDetailsById(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        //assertEquals(null, result.getBody());
        verify(userRepo, times(1)).findById(userId);
    }
}
