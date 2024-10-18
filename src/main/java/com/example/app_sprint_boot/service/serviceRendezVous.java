package com.example.app_sprint_boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app_sprint_boot.Exception.RendezVousException;
import com.example.app_sprint_boot.models.RendezVous;
import com.example.app_sprint_boot.resposity.rendezVousResposity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class serviceRendezVous {
    private final rendezVousResposity rendezVousRes;

@Autowired

public serviceRendezVous(rendezVousResposity rendezVousRes) {
        this.rendezVousRes = rendezVousRes;
    }
    public RendezVous ajouterRV(RendezVous rv){
        return rendezVousRes.save(rv);  // Sauvegarde le rendez-vous
    }
    


public List<RendezVous> trouverRV(){
    return rendezVousRes.findAll();
}
public void SupprimerRvById(Long id){
    rendezVousRes.deleteById(id);  // Correctement supprimer un rendez-vous par son ID
}
public RendezVous trouverRVById(Long id){
    return rendezVousRes.findById(id).orElseThrow(()->new RendezVousException ("rendez-vous avec id"+id+"n'existe pas"));

}


}
