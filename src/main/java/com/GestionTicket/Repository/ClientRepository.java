package com.GestionTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Client;
import com.GestionTicket.Entitie.Compte;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
