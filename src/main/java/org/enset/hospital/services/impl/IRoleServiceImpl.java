package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.RoleRequestDTO;
import org.enset.hospital.dto.response.RoleResponseDTO;
import org.enset.hospital.entites.Role;
import org.enset.hospital.repositories.RoleRepository;
import org.enset.hospital.services.facade.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleRequestDTO savedRole(Role role) {
        Role rolesaved = roleRepository.save(role);
        return modelMapper.map(rolesaved, RoleRequestDTO.class);
    }

    @Override
    public RoleResponseDTO getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        List<RoleRequestDTO> roleRequestDTOS = roles.stream().map(role -> modelMapper.map(role, RoleRequestDTO.class)).collect(Collectors.toList());

        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setContent(roleRequestDTOS);
        return roleResponseDTO;
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return modelMapper.map(role, RoleResponseDTO.class);
    }

    @Override
    public RoleResponseDTO getRoleByNom(String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        return modelMapper.map(role,RoleResponseDTO.class);
    }

    @Override
    public RoleRequestDTO updatedRole(Long id, Role role) {
        Role roleUpdated = roleRepository.findById(id).orElse(null);

        roleUpdated.setRoleName(role.getRoleName());
        roleUpdated.setDescription(role.getDescription());

        Role savedRole = roleRepository.save(roleUpdated);
        return modelMapper.map(savedRole, RoleRequestDTO.class);
    }

    @Override
    public String deletedRole(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        roleRepository.delete(role);
        return "Role with roleId: " + id + " deleted successfully !!!";
    }
}
