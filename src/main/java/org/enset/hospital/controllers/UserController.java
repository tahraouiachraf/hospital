package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.UserRequestDTO;
import org.enset.hospital.dto.response.UserResponseDTO;
import org.enset.hospital.entites.User;
import org.enset.hospital.services.facade.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<UserResponseDTO> getAllUsers() {
        UserResponseDTO userResponseDTO = userService.getAllUsers();
        return new ResponseEntity<>(userResponseDTO, HttpStatus.FOUND);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserRequestDTO> savedUser(@RequestBody User user) {
        UserRequestDTO userRequestDTO = userService.savedUser(user);
        return new ResponseEntity<>(userRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserRequestDTO> updatedUser(@PathVariable Long userId,@RequestBody User user) {
        UserRequestDTO userRequestDTO = userService.updatedUser(userId,user);
        return new ResponseEntity<>(userRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deletedUser(@PathVariable Long userId) {
        String status = userService.deletedUser(userId);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
