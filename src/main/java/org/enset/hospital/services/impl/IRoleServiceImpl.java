package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.RoleRequestDTO;
import org.enset.hospital.dto.response.RoleResponseDTO;
import org.enset.hospital.entites.Role;
import org.enset.hospital.services.facade.IRoleService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Override
    public RoleRequestDTO savedRole(Role role) {
        return null;
    }

    @Override
    public RoleResponseDTO getAllRoles() {
        return null;
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        return null;
    }

    @Override
    public RoleResponseDTO getRoleByNom(String nom) {
        return null;
    }

    @Override
    public RoleRequestDTO updatedRole(Long id, Role role) {
        return null;
    }

    @Override
    public String deletedRole(Long id) {
        return null;
    }
}
