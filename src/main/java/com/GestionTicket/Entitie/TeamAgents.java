package com.GestionTicket.Entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TeamAgents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTeamAgent;
	
	@ManyToOne
	@JoinColumn(name = "idTeam")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "idAgent")
	private Agent agent;

	public Long getIdTeamAgent() {
		return idTeamAgent;
	}

	public void setIdTeamAgent(Long idTeamAgent) {
		this.idTeamAgent = idTeamAgent;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	
	
}
