package org.enset.hospital.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationRequestDTO {
    private Long id;
    private Date dateConsultation;
    private String rapport;
}
