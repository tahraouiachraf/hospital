package org.enset.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.hospital.dto.request.MedecinRequestDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedecinResponseDTO {
    private List<MedecinRequestDTO> content;
}
