package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.ConsultationRequestDTO;
import org.enset.hospital.dto.response.ConsultationResponseDTO;
import org.enset.hospital.entites.Consultation;
import org.enset.hospital.services.facade.IConsultationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsultationRestController {
    @Autowired
    private IConsultationSevice consultationSevice;

    @GetMapping("/consultations")
    public ResponseEntity<ConsultationResponseDTO> consultationList() {
        ConsultationResponseDTO consultationResponseDTO = consultationSevice.getAllConsultations();
        return new ResponseEntity<>(consultationResponseDTO, HttpStatus.FOUND);
    }

    @PostMapping("/consultation")
    public ResponseEntity<ConsultationRequestDTO> savedConsultation(@RequestBody Consultation consultation) {
        ConsultationRequestDTO consultationRequestDTO = consultationSevice.saveConsultation(consultation);
        return new ResponseEntity<>(consultationRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/consultation/{id}")
    public ResponseEntity<ConsultationRequestDTO> updatedConsultation(@PathVariable Long id,@RequestBody Consultation consultation) {
        ConsultationRequestDTO consultationRequestDTO = consultationSevice.updateConsultation(id,consultation);
        return new ResponseEntity<>(consultationRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/consultation/{id}")
    public ResponseEntity<String> deletedConsultation(@PathVariable Long id) {
        String status = consultationSevice.deleteConsultation(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
