package com.spring.hexagonal.hexagonal.infraestructure.controller;

import com.spring.hexagonal.hexagonal.application.UserDto;
import com.spring.hexagonal.hexagonal.application.port.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto salvar(@RequestBody UserDto userDto) {
        logger.info("Creating user with document number: {}", userDto.getNumberDocument());
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto actualizar(@PathVariable Long id, @RequestBody UserDto userDto) {
        logger.info("Updating user with id: {}", id);
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/{id}")
    public Optional<UserDto> findById(@PathVariable Long id) {
        logger.info("Fetching user with id: {}", id);
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDto> findAll() {
        logger.info("Fetching all users");
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        logger.info("Deleting user with id: {}", id);
        userService.deleteUser(id);
    }

    @GetMapping("/document/{numberDocument}")
    public Optional<UserDto> findByNumberDocument(@PathVariable Integer numberDocument) {
        logger.info("Fetching user with document number: {}", numberDocument);
        return userService.findByNumberDocument(numberDocument);
    }

}