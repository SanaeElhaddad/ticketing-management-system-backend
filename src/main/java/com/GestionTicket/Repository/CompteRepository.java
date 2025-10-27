package com.GestionTicket.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	Compte findByEmail(String email);
   
   

}
