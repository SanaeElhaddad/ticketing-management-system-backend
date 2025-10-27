package com.GestionTicket.Entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Statut {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatut;

    private String nom;


	public Long getIdStatut() {
		return idStatut;
	}

	public void setIdStatut(Long idStatut) {
		this.idStatut = idStatut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
    

}
