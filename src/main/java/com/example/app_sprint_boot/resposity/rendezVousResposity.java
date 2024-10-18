package com.example.app_sprint_boot.resposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app_sprint_boot.models.RendezVous;

public interface rendezVousResposity extends JpaRepository<RendezVous, Long>{

    rendezVousResposity save(rendezVousResposity rv);

    
} 
