package com.GestionTicket.Entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ApplicationClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApplicationClient;
	
	@ManyToOne
	@JoinColumn(name = "IdApplication")
	private Application IdApplication;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client idClient;
	
	@ManyToOne
	@JoinColumn(name = "idTeam")
	private Team idTeam;

	public Long getIdApplicationClient() {
		return idApplicationClient;
	}

	public void setIdApplicationClient(Long idApplicationClient) {
		this.idApplicationClient = idApplicationClient;
	}

	
	

	public Application getIdApplication() {
		return IdApplication;
	}

	public void setIdApplication(Application idApplication) {
		IdApplication = idApplication;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public Team getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Team idTeam) {
		this.idTeam = idTeam;
	}

	
	
}
