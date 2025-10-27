package com.GestionTicket.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Comment;
import com.GestionTicket.Entitie.Compte;
import com.GestionTicket.Entitie.Ticket;
import com.GestionTicket.Service.CommentService;
import com.GestionTicket.Service.CompteService;
import com.GestionTicket.Service.TicketService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/comments/{idTicket}")
	public List<Comment> getCommentByTicket(@PathVariable Long idTicket) {
		return service.findAllByTicket(idTicket);
	}
	
	@PostMapping("/comment/add")
	public Comment addComment(@RequestBody Comment c) {
	    Logger logger = LoggerFactory.getLogger(CommentController.class);
	    
	    // Vérifier si l'ID de Compte est présent
	    if (c.getCompte() == null || c.getCompte().getIdCompte() == null) {
	        logger.error("L'ID du compte est null.");
	        throw new IllegalArgumentException("L'ID du compte ne doit pas être null.");
	    }

	    // Vérifier si l'ID de Ticket est présent
	    if (c.getTicket() == null || c.getTicket().getIdTicket() == null) {
	        logger.error("L'ID du ticket est null.");
	        throw new IllegalArgumentException("L'ID du ticket ne doit pas être null.");
	    }

	    // Charger l'entité Compte depuis la base de données par ID
	    Optional<Compte> optionalCompte = compteService.findById(c.getCompte().getIdCompte());
	    if (!optionalCompte.isPresent()) {
	        logger.error("Le compte avec l'ID {} n'existe pas.", c.getCompte().getIdCompte());
	        throw new EntityNotFoundException("Le compte avec l'ID spécifié n'existe pas.");
	    }

	    // Charger l'entité Ticket depuis la base de données par ID
	    Optional<Ticket> optionalTicket = ticketService.findById(c.getTicket().getIdTicket());
	    if (!optionalTicket.isPresent()) {
	        logger.error("Le ticket avec l'ID {} n'existe pas.", c.getTicket().getIdTicket());
	        throw new EntityNotFoundException("Le ticket avec l'ID spécifié n'existe pas.");
	    }

	    // Associer les objets récupérés
	    c.setCompte(optionalCompte.get());
	    c.setTicket(optionalTicket.get());

	    // Définir la date
	    c.setDate(new Date());

	    // Sauvegarder le commentaire
	    Comment savedComment = service.saveComment(c);
	    logger.info("Commentaire ajouté avec succès : {}", savedComment);
	    return savedComment;
	}

	

}
