package org.enset.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.dto.request.PatientRequestDTO;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {
    private List<PatientRequestDTO> content;
}
