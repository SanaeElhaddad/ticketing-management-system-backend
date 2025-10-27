package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Team;
import com.GestionTicket.Entitie.TeamAgents;
import com.GestionTicket.Service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	
	@Autowired
	TeamService service;
	
	@GetMapping("/teams/{idAgent}")
	public List<TeamAgents> findTeamByAgent (@PathVariable Long idAgent) {
		return service.findTeamByAgent(idAgent);
	}
	

}
