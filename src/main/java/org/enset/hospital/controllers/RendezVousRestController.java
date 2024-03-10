package org.enset.hospital.controllers;

import org.enset.hospital.dto.request.RendezVousRequestDTO;
import org.enset.hospital.dto.response.RendezVousResponseDTO;
import org.enset.hospital.entites.RendezVous;
import org.enset.hospital.services.facade.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RendezVousRestController {
    @Autowired
    private IRendezVousService rendezVousService;

    @GetMapping("/rendezvous")
    public ResponseEntity<RendezVousResponseDTO> rendezVousList() {
        RendezVousResponseDTO rendezVousResponseDTO = rendezVousService.getAllRendezVouss();
        return new ResponseEntity<>(rendezVousResponseDTO, HttpStatus.FOUND);
    }

    @PostMapping("/rendezvous")
    public ResponseEntity<RendezVousRequestDTO> addRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVousRequestDTO rendezVousRequestDTO = rendezVousService.saveRendezVous(rendezVous);
        return new ResponseEntity<>(rendezVousRequestDTO,HttpStatus.CREATED);
    }

    @PutMapping("/rendezvous/{id}")
    public ResponseEntity<RendezVousRequestDTO> updateRendezVous(@PathVariable Long id,@RequestBody RendezVous rendezVous) {
        RendezVousRequestDTO rendezVousRequestDTO = rendezVousService.updateRendezVous(id,rendezVous);
        return new ResponseEntity<>(rendezVousRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/rendezvous/{id}")
    public ResponseEntity<String> deleteRendezVous(@PathVariable Long id) {
        String status = rendezVousService.deleteRendezVous(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
