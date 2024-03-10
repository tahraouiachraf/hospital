package org.enset.hospital.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
}
