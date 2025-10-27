package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Categorie;
import com.GestionTicket.Service.CategorieService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
	
	@Autowired
	private CategorieService service;
	
	@GetMapping("/categories")
	public List<Categorie> getAllCategories() {
		return service.findAllCategories();
	}
	
	/*@GetMapping("/nom_categories")
	public List<String> getAllCategoriesByNom() {
		return service.findAllCategoryNames();
	}*/
	

}
