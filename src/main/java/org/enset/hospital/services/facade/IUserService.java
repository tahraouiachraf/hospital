package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.UserRequestDTO;
import org.enset.hospital.dto.response.UserResponseDTO;
import org.enset.hospital.entites.User;

public interface IUserService {
    UserRequestDTO savedUser(User user);
    UserResponseDTO getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO getUserByNom(String nom);
    UserRequestDTO updatedUser(Long id,User user);
    String deletedUser(Long id);
}
