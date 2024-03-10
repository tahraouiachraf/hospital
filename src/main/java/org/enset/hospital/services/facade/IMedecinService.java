package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.MedecinRequestDTO;
import org.enset.hospital.dto.response.MedecinResponseDTO;
import org.enset.hospital.entites.Medecin;

import java.util.List;

public interface IMedecinService {
    MedecinRequestDTO saveMedecin(Medecin medecin);
    MedecinResponseDTO getAllMedecins();
    MedecinRequestDTO updateMedecin(Long id, Medecin medecin);
    String deleteMedecin(Long id);
}
