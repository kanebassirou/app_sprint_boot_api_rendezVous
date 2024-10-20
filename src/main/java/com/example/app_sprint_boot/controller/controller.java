package com.example.app_sprint_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_sprint_boot.Exception.RendezVousException;
import com.example.app_sprint_boot.models.RendezVous;
import com.example.app_sprint_boot.resposity.rendezVousResposity;
import com.example.app_sprint_boot.service.serviceRendezVous;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rendezvous")
@Tag(name = "Api RendezVous", description = "Un api pour la gestion des rendez-vous")

public class controller {
    @GetMapping("/")
    @Operation(summary = "la page de bienvenue", description = "une page qui retourne un message de bienvenue")

    public ResponseEntity<String> index() {
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
    @Operation(summary = "Ajouter une nouvelle Rendez-vous", description = "permettent d'ajouter un nouveau rendez-vous dans la base de données")

    public ResponseEntity<RendezVous> ajouterRV(@RequestBody RendezVous rv) {
        RendezVous nouveauRV = serviceRendez.ajouterRV(rv); // Appel du service pour sauvegarder un rendez-vous
        return new ResponseEntity<>(nouveauRV, HttpStatus.CREATED);
    }

    // endpoint pour trouver tous les rendez-vous
    @GetMapping("/liste")
    @Operation(summary = "Lister les differente  RendezVous", description = "une page qui permet d'ajouter la liste des rendez-vous dans la base de données")

    public ResponseEntity<List<RendezVous>> obtenirTousLesRendezVous() {
        List<RendezVous> rendezVousList = serviceRendez.trouverRV();
        return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
    }

    // endpoint pour modifier un rendez-vous
    @PutMapping("/modifier/{id}")
    @Operation(summary = "Modifier un rendez-vous", description = "Permet de modifier un rendez-vous existant dans la base de données par son ID")
    public ResponseEntity<RendezVous> modifierRendezVous(@PathVariable Long id, @RequestBody RendezVous rv) {
        try {
            rv.setId(id); // Assurez-vous que l'ID du rendez-vous est défini
            RendezVous updatedRV = serviceRendez.modifierRV(rv);
            return new ResponseEntity<>(updatedRV, HttpStatus.OK);
        } catch (RendezVousException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // endpoint pour supprimer un rendez-vous par son ID
    @DeleteMapping("/supprimer/{id}")
    @Operation(summary = "Supprimer un rendez-vous ", description = "une page qui permet de supprimer un rendez-vous dans la base de données par son ID")

    public ResponseEntity<Void> supprimerRendezVous(@PathVariable Long id) {
        serviceRendez.SupprimerRvById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // endpoint pour trouver un rendez-vous par son ID
    @GetMapping("/{id}")
    @Operation(summary = "Afficher un rendez-vous", description = "Une page qui permet d'afficher un rendez-vous dans la base de données par son ID")

    public ResponseEntity<RendezVous> obtenirRendezVousParId(@PathVariable Long id) {
        RendezVous rendezVous = serviceRendez.trouverRVById(id);
        return new ResponseEntity<>(rendezVous, HttpStatus.OK);
    }
}
