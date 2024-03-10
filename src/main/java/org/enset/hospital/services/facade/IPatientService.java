package org.enset.hospital.services.facade;

import org.enset.hospital.dto.request.PatientRequestDTO;
import org.enset.hospital.dto.response.PatientResponseDTO;
import org.enset.hospital.entites.Patient;

public interface IPatientService {
    PatientRequestDTO savePatient(Patient patient);
    PatientResponseDTO getAllPatients();
    PatientRequestDTO updatePatient(Long id, Patient patient);
    String deletePatient(Long id);
}
