package com.spring.hexagonal.hexagonal.application.port;

import com.spring.hexagonal.hexagonal.application.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDTO);
    Optional<UserDto> getUser(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDTO);
    void deleteUser(Long id);
    Optional<UserDto> findByNumberDocument(Integer numberDocument);
}
