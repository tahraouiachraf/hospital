package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.UserRequestDTO;
import org.enset.hospital.dto.response.UserResponseDTO;
import org.enset.hospital.entites.User;
import org.enset.hospital.repositories.UserRepository;
import org.enset.hospital.services.facade.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRequestDTO savedUser(User user) {
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser,UserRequestDTO.class);
    }

    @Override
    public UserResponseDTO getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserRequestDTO> userRequestDTOS = users.stream().map(user -> modelMapper.map(user,UserRequestDTO.class)).collect(Collectors.toList());

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setContent(userRequestDTOS);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return modelMapper.map(user,UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserByNom(String nom) {
        return null;
    }

    @Override
    public UserRequestDTO updatedUser(Long id, User user) {
        User updatedUser = userRepository.findById(id).orElse(null);

        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRoles(user.getRoles());

        User saved = userRepository.save(updatedUser);
        return modelMapper.map(saved,UserRequestDTO.class);
    }

    @Override
    public String deletedUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return "User with userId: " + id + " deleted successfully !!!";
    }
}
