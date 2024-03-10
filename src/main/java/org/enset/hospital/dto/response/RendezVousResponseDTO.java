package org.enset.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.dto.request.RendezVousRequestDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVousResponseDTO {
    private List<RendezVousRequestDTO> content;
}
