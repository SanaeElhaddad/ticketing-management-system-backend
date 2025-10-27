package com.GestionTicket.Entitie;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Agent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAgent")
    private Long idAgent;

	
    @Column(name = "nom")
    private String nom;
	
    @Column(name = "email")
    private String email;
    

	public Long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	
}
