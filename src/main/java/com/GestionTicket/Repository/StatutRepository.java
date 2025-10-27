package com.GestionTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Statut;

public interface StatutRepository extends JpaRepository<Statut, Long> {
	Statut findByNom(String nom);

}
