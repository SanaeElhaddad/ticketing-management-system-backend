package com.GestionTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.TeamAgents;

public interface TeamRepository extends JpaRepository<TeamAgents, Long> {
	List<TeamAgents> findByAgentIdAgent(Long idAgent);

}
