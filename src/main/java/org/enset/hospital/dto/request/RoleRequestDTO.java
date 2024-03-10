package org.enset.hospital.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.entites.User;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDTO {
    private Long roleId;
    private String description;
    private String roleName;
    private List<User> users = new ArrayList<>();
}
