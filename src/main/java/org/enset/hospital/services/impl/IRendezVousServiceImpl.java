package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.RendezVousRequestDTO;
import org.enset.hospital.dto.response.RendezVousResponseDTO;
import org.enset.hospital.entites.RendezVous;
import org.enset.hospital.repositories.RendezVousRepository;
import org.enset.hospital.services.facade.IRendezVousService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IRendezVousServiceImpl implements IRendezVousService {
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RendezVousRequestDTO saveRendezVous(RendezVous rendezVous) {
        RendezVous saved = rendezVousRepository.save(rendezVous);
        return modelMapper.map(saved,RendezVousRequestDTO.class);
    }

    @Override
    public RendezVousResponseDTO getAllRendezVouss() {
        List<RendezVous> rendezVous = rendezVousRepository.findAll();

        List<RendezVousRequestDTO> rendezVousRequestDTOS = rendezVous.stream().map(rendezVous1 -> modelMapper.map(rendezVous1,RendezVousRequestDTO.class)).collect(Collectors.toList());

        RendezVousResponseDTO rendezVousResponseDTO = new RendezVousResponseDTO();
        rendezVousResponseDTO.setContent(rendezVousRequestDTOS);
        return rendezVousResponseDTO;
    }

    @Override
    public RendezVousRequestDTO updateRendezVous(Long id, RendezVous rendezVous) {
        RendezVous updatedRendezVous = rendezVousRepository.findById(id).orElse(null);

        updatedRendezVous.setMedecin(rendezVous.getMedecin());
        updatedRendezVous.setConsultation(rendezVous.getConsultation());
        updatedRendezVous.setPatient(rendezVous.getPatient());
        updatedRendezVous.setDate(rendezVous.getDate());
        updatedRendezVous.setStatus(rendezVous.getStatus());


        RendezVous savedRendezVous = rendezVousRepository.save(updatedRendezVous);
        return modelMapper.map(savedRendezVous,RendezVousRequestDTO.class);
    }

    @Override
    public String deleteRendezVous(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id).orElse(null);
        rendezVousRepository.delete(rendezVous);
        return "RendezVous with rendezVousId: " + id + " deleted successfully !!!";
    }
}
