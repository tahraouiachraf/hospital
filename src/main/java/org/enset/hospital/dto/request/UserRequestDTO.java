package org.enset.hospital.dto.request;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.entites.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Long userId;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();
}
