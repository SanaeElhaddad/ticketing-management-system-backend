package com.GestionTicket.Entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Priorite {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriorite;

    private String nom;


	public Long getIdPriorite() {
		return idPriorite;
	}

	public void setIdPriorite(Long idPriorite) {
		this.idPriorite = idPriorite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
}
