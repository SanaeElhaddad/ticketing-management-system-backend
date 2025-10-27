package com.GestionTicket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Categorie;
import com.GestionTicket.Repository.CategorieRepository;

@Service
public class CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;
	
	public List<Categorie> findAllCategories(){
		return categorieRepository.findAll();
	}
	
	//public List<String> findAllCategoryNames() {
      //  return categorieRepository.findAllByOrderByNomAsc()
         //       .stream()
         //       .map(Categorie::getNom)
         //       .collect(Collectors.toList());
   // }
}
