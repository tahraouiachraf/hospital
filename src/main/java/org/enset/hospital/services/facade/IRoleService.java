package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.RoleRequestDTO;
import org.enset.hospital.dto.response.RoleResponseDTO;
import org.enset.hospital.entites.Role;

public interface IRoleService {
    RoleRequestDTO savedRole(Role role);
    RoleResponseDTO getAllRoles();
    RoleResponseDTO getRoleById(Long id);
    RoleResponseDTO getRoleByNom(String nom);
    RoleRequestDTO updatedRole(Long id,Role role);
    String deletedRole(Long id);
}
