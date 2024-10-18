package com.example.app_sprint_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_sprint_boot.models.RendezVous;
import com.example.app_sprint_boot.resposity.rendezVousResposity;
import com.example.app_sprint_boot.service.serviceRendezVous;


@RestController
@RequestMapping("/rendezvous")
public class controller {
    @GetMapping("/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("Bienvenue sur mon backend Spring Boot", HttpStatus.OK);
    }

    private final serviceRendezVous serviceRendez;

    @Autowired
    public controller(serviceRendezVous serviceRendez) {
        this.serviceRendez = serviceRendez;
    }

    // endpoint pour ajouter un rendez-vous
   // endpoint pour ajouter un rendez-vous
@PostMapping("/ajouter")
public ResponseEntity<RendezVous> ajouterRV(@RequestBody RendezVous rv){
    RendezVous nouveauRV = serviceRendez.ajouterRV(rv);  // Appel du service pour sauvegarder un rendez-vous
    return new ResponseEntity<>(nouveauRV, HttpStatus.CREATED);
}


    // endpoint pour trouver tous les rendez-vous
    @GetMapping("/liste")
    public ResponseEntity<List<RendezVous>> obtenirTousLesRendezVous() {
        List<RendezVous> rendezVousList = serviceRendez.trouverRV();
        return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
    }

    // endpoint pour supprimer un rendez-vous par son ID
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerRendezVous(@PathVariable Long id) {
        serviceRendez.SupprimerRvById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // endpoint pour trouver un rendez-vous par son ID
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> obtenirRendezVousParId(@PathVariable Long id) {
        RendezVous rendezVous = serviceRendez.trouverRVById(id);
        return new ResponseEntity<>(rendezVous, HttpStatus.OK);
    }
}
