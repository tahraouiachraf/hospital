package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.MedecinRequestDTO;
import org.enset.hospital.dto.response.MedecinResponseDTO;
import org.enset.hospital.entites.Medecin;
import org.enset.hospital.services.facade.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedecinRestController {
    @Autowired
    private IMedecinService medecinService;

    @GetMapping("/medecins")
    public ResponseEntity<MedecinResponseDTO> medecinList() {
        MedecinResponseDTO medecinResponseDTO = medecinService.getAllMedecins();
        return new ResponseEntity<>(medecinResponseDTO, HttpStatus.FOUND);
    }

    @PostMapping("/medecin")
    public ResponseEntity<MedecinRequestDTO> savedMedecin(@RequestBody Medecin medecin) {
        MedecinRequestDTO medecinRequestDTO = medecinService.saveMedecin(medecin);
        return new ResponseEntity<>(medecinRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/medecin/{id}")
    public ResponseEntity<MedecinRequestDTO> updatedMedecin(@PathVariable Long id,@RequestBody Medecin medecin) {
        MedecinRequestDTO medecinRequestDTO = medecinService.updateMedecin(id,medecin);
        return new ResponseEntity<>(medecinRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/medecin/{id}")
    public ResponseEntity<String> deletedMedecin(@PathVariable Long id) {
        String status = medecinService.deleteMedecin(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
