package com.GestionTicket.Service;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Comment;
import com.GestionTicket.Repository.CommentaireRepository;

@Service
public class CommentService {

	@Autowired
	CommentaireRepository commentRepository;
	
	public List<Comment> findAllByTicket(Long idTicket) {
		
		return commentRepository.findByTicketIdTicket(idTicket);
		
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
		 
	}
}
