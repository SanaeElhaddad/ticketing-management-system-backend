package com.GestionTicket.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByClientIdClient(Long idClient);


}
