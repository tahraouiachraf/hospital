package org.enset.hospital.services.impl;

import jakarta.transaction.Transactional;
import org.enset.hospital.dto.request.PatientRequestDTO;
import org.enset.hospital.dto.response.PatientResponseDTO;
import org.enset.hospital.entites.Patient;
import org.enset.hospital.repositories.PatientRepository;
import org.enset.hospital.services.facade.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IPatientServiceImpl implements IPatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientRequestDTO savePatient(Patient patient) {
        Patient saved = patientRepository.save(patient);
        return modelMapper.map(saved, PatientRequestDTO.class);
    }

    @Override
    public PatientResponseDTO getAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientRequestDTO> patientRequestDTOS = patients.stream().map(patient -> modelMapper.map(patient, PatientRequestDTO.class)).collect(Collectors.toList());

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setContent(patientRequestDTOS);
        return patientResponseDTO;
    }

    @Override
    public PatientRequestDTO updatePatient(Long id, Patient patient) {
        Patient updatedPatient = patientRepository.findById(id).orElse(null);

        updatedPatient.setNom(patient.getNom());
        updatedPatient.setDateNaissance(patient.getDateNaissance());
        updatedPatient.setMalade(patient.isMalade());

        Patient savedPatient = patientRepository.save(updatedPatient);
        return modelMapper.map(savedPatient, PatientRequestDTO.class);
    }

    @Override
    public String deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        patientRepository.delete(patient);
        return "Patient with patientId: " + id + " deleted successfully !!!";
    }
}
