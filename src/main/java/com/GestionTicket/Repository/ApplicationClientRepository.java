package com.GestionTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.ApplicationClient;

public interface ApplicationClientRepository extends JpaRepository<ApplicationClient, Long> {
	
	

}
