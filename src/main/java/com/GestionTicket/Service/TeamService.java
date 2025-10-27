package com.GestionTicket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.TeamAgents;
import com.GestionTicket.Repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository teamRepository;
	
	public List<TeamAgents> findTeamByAgent(long idAgent) {
		return teamRepository.findByAgentIdAgent(idAgent);
	}

}
