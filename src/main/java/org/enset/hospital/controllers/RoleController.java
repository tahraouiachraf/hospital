package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.RoleRequestDTO;
import org.enset.hospital.dto.response.RoleResponseDTO;
import org.enset.hospital.entites.Role;
import org.enset.hospital.services.facade.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<RoleResponseDTO> getAllRoles() {
        RoleResponseDTO roleResponseDTO = roleService.getAllRoles();
        return new ResponseEntity<>(roleResponseDTO, HttpStatus.FOUND);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable Long id) {
        RoleResponseDTO roleResponseDTO = roleService.getRoleById(id);
        return new ResponseEntity<>(roleResponseDTO,HttpStatus.FOUND);
    }

    @PostMapping("/role")
    public ResponseEntity<RoleRequestDTO> savedRole(@RequestBody Role role) {
        RoleRequestDTO roleRequestDTO = roleService.savedRole(role);
        return new ResponseEntity<>(roleRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<RoleRequestDTO> updatedRole(@RequestBody Role role,@PathVariable Long id) {
        RoleRequestDTO roleRequestDTO = roleService.updatedRole(id,role);
        return new ResponseEntity<>(roleRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> deletedRole(@PathVariable Long id) {
        String status = roleService.deletedRole(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

}
