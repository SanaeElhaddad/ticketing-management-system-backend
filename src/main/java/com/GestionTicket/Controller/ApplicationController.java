package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Application;
import com.GestionTicket.Service.ApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {
	
	@Autowired
	private ApplicationService service;
	
	@GetMapping("/applications")
	public List<Application> getAllApplication() {
		return service.getAllApplication();
	}
	
	@GetMapping("/application/{idApplication}")
	public Application getMethodName(@PathVariable Long idApplication) {
		return service.getApplicationById(idApplication);
	}
	
	

}
