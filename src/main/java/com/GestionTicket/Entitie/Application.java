package com.GestionTicket.Entitie;

import jakarta.persistence.*;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApplication;
	private String nom;
	private String description;
	

	public Long getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
