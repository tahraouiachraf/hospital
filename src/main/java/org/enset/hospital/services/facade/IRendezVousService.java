package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.RendezVousRequestDTO;
import org.enset.hospital.dto.response.RendezVousResponseDTO;
import org.enset.hospital.entites.RendezVous;

public interface IRendezVousService {
    RendezVousRequestDTO saveRendezVous(RendezVous rendezVous);
    RendezVousResponseDTO getAllRendezVouss();
    RendezVousRequestDTO updateRendezVous(Long id, RendezVous rendezVous);
    String deleteRendezVous(Long id);
}
