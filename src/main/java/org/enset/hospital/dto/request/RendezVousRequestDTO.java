package org.enset.hospital.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.entites.Consultation;
import org.enset.hospital.entites.Medecin;
import org.enset.hospital.entites.Patient;
import org.enset.hospital.entites.StatusRDV;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVousRequestDTO {
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
//    private Patient patient;
//    private Medecin medecin;
//    private Consultation consultation;
}
