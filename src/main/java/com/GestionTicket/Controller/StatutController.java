package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Statut;
import com.GestionTicket.Service.StatutService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StatutController {
	
	@Autowired
	private StatutService service;
	
	@GetMapping("/statuts")
	public List<Statut> getAllStatuts() {
		return service.findAllStatuts();
	}
	

}
