package org.enset.hospital.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedecinRequestDTO {
    private Long id;
    private String nom;
    private String email;
    private String specialite;
}
