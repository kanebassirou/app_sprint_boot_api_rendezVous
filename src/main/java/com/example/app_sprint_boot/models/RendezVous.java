package com.example.app_sprint_boot.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rendez_vous")
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String codeRV;

    private String description;
    private String lieu;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public RendezVous() {
        super();
    }

    public RendezVous(String codeRV, String description, String lieu, LocalDate date) {
        super();
        this.codeRV = codeRV;
        this.description = description;
        this.lieu = lieu;
        this.date = date;
    }
}

