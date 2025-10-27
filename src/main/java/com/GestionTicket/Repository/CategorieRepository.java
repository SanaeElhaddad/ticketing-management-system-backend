package com.GestionTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	List<Categorie> findAllByOrderByNomAsc();
}
