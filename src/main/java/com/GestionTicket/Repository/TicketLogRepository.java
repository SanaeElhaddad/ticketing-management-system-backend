package com.GestionTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.TicketLog;

public interface TicketLogRepository extends JpaRepository<TicketLog, Long>{
	List<TicketLog> findByTicketIdTicket(Long ticketId);

}
