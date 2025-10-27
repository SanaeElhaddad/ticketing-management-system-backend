package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Priorite;
import com.GestionTicket.Service.PrioriteService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PrioriteController {
	
	@Autowired
	private PrioriteService service;
	
	@GetMapping("/priorites")
	public List<Priorite> getAllPriorites() {
		return service.findAllPriorites();
	}
	

}
