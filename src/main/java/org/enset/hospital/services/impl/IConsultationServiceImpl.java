package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.ConsultationRequestDTO;
import org.enset.hospital.dto.response.ConsultationResponseDTO;
import org.enset.hospital.entites.Consultation;
import org.enset.hospital.repositories.ConsultationRepository;
import org.enset.hospital.services.facade.IConsultationSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IConsultationServiceImpl implements IConsultationSevice {

    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ConsultationRequestDTO saveConsultation(Consultation consultation) {
        Consultation savedConsultation = consultationRepository.save(consultation);
        return modelMapper.map(savedConsultation,ConsultationRequestDTO.class);
    }

    @Override
    public ConsultationResponseDTO getAllConsultations() {
        List<Consultation> consultations = consultationRepository.findAll();

        List<ConsultationRequestDTO> consultationRequestDTOS = consultations.stream().map(consultation -> modelMapper.map(consultation,ConsultationRequestDTO.class)).collect(Collectors.toList());

        ConsultationResponseDTO consultationResponseDTO = new ConsultationResponseDTO();
        consultationResponseDTO.setContent(consultationRequestDTOS);
        return consultationResponseDTO;
    }

    @Override
    public ConsultationRequestDTO updateConsultation(Long id, Consultation consultation) {
        Consultation updated = consultationRepository.findById(id).orElse(null);

        updated.setRapport(consultation.getRapport());
        updated.setDateConsultation(consultation.getDateConsultation());
        updated.setRendezVous(consultation.getRendezVous());

        Consultation savedConsultation = consultationRepository.save(updated);
        return modelMapper.map(savedConsultation,ConsultationRequestDTO.class);
    }

    @Override
    public String deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id).orElse(null);
        consultationRepository.delete(consultation);
        return "Consultation with consultationId: " + id + " deleted successfully !!!";
    }
}
