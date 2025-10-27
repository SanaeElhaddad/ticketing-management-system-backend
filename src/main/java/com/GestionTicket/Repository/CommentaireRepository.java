package com.GestionTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Comment;

public interface CommentaireRepository extends JpaRepository<Comment, Long> {
	List<Comment>findByTicketIdTicket(long idTicket);

}
