package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.ConsultationRequestDTO;
import org.enset.hospital.dto.response.ConsultationResponseDTO;
import org.enset.hospital.entites.Consultation;

public interface IConsultationSevice {
    ConsultationRequestDTO saveConsultation(Consultation consultation);
    ConsultationResponseDTO getAllConsultations();
    ConsultationRequestDTO updateConsultation(Long id, Consultation consultation);
    String deleteConsultation(Long id);
}
