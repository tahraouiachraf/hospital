package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.PatientRequestDTO;
import org.enset.hospital.dto.response.PatientResponseDTO;
import org.enset.hospital.entites.Patient;
import org.enset.hospital.services.facade.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientRestController {
    @Autowired
    private IPatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<PatientResponseDTO> patientList() {
        PatientResponseDTO patientResponseDTO = patientService.getAllPatients();
        return new ResponseEntity<>(patientResponseDTO, HttpStatus.FOUND);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientRequestDTO> savedPatient(@RequestBody Patient patient) {
        PatientRequestDTO patientRequestDTO = patientService.savePatient(patient);
        return new ResponseEntity<>(patientRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientRequestDTO> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        PatientRequestDTO updatePatient =patientService.updatePatient(id,patient);
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        String status = patientService.deletePatient(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
