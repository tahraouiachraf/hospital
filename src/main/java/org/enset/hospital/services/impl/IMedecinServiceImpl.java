package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.MedecinRequestDTO;
import org.enset.hospital.dto.response.MedecinResponseDTO;
import org.enset.hospital.entites.Medecin;
import org.enset.hospital.repositories.MedecinRepository;
import org.enset.hospital.services.facade.IMedecinService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IMedecinServiceImpl implements IMedecinService {
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedecinRequestDTO saveMedecin(Medecin medecin) {
        Medecin savedMedecin = medecinRepository.save(medecin);
        return modelMapper.map(savedMedecin, MedecinRequestDTO.class);
    }

    @Override
    public MedecinResponseDTO getAllMedecins() {
        List<Medecin> medecins = medecinRepository.findAll();

        List<MedecinRequestDTO> medecinRequestDTOS = medecins.stream().map(medecin -> modelMapper.map(medecin, MedecinRequestDTO.class)).collect(Collectors.toList());

        MedecinResponseDTO medecinResponseDTO = new MedecinResponseDTO();
        medecinResponseDTO.setContent(medecinRequestDTOS);
        return medecinResponseDTO;
    }

    @Override
    public MedecinRequestDTO updateMedecin(Long id, Medecin medecin) {
        Medecin updateMedecin = medecinRepository.findById(id).orElse(null);

        updateMedecin.setNom(medecin.getNom());
        updateMedecin.setEmail(medecin.getEmail());
        updateMedecin.setSpecialite(medecin.getSpecialite());

        Medecin savedMedecin = medecinRepository.save(updateMedecin);
        return modelMapper.map(savedMedecin,MedecinRequestDTO.class);
    }

    @Override
    public String deleteMedecin(Long id) {
        Medecin medecin = medecinRepository.findById(id).orElse(null);
        medecinRepository.delete(medecin);
        return "Medecin with medecinId: " + id + " deleted successfully !!!";
    }
}
