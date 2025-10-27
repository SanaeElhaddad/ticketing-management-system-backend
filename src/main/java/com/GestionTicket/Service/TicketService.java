package com.GestionTicket.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Application;
import com.GestionTicket.Entitie.Categorie;
import com.GestionTicket.Entitie.Client;
import com.GestionTicket.Entitie.Priorite;
import com.GestionTicket.Entitie.Statut;
import com.GestionTicket.Entitie.Ticket;
import com.GestionTicket.Entitie.TicketLog;
import com.GestionTicket.Repository.ApplicationRepository;
import com.GestionTicket.Repository.CategorieRepository;
import com.GestionTicket.Repository.ClientRepository;
import com.GestionTicket.Repository.PrioriteRepository;
import com.GestionTicket.Repository.StatutRepository;
import com.GestionTicket.Repository.TicketLogRepository;
import com.GestionTicket.Repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	StatutRepository statutRepository;
	
	@Autowired
    PrioriteRepository prioriteRepository;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	TicketLogRepository logRepository;
	
	
	public Ticket addTicketTest(Ticket ticket) {
	 // Définir la date de création et de mise à jour
        Date currentDate = new Date();
        ticket.setDateCreation(currentDate);
        ticket.setDateMaj(currentDate);
        if ("Fermé".equals(ticket.getStatut().getNom())) {
            ticket.setDateLivraison(new Date());
        } else {
            ticket.setDateLivraison(null);
        }
        Ticket savedTicket = ticketRepository.save(ticket);
        
     // Ajouter une entrée dans TicketLog
        TicketLog log = new TicketLog();
        log.setTicket(savedTicket);
        log.setAction("Création de ticket");
        log.setValeurPrec(null);
        log.setValeurSuiv(savedTicket.toString());
        log.setDate(currentDate);

        logRepository.save(log);

        return savedTicket;
	}

	
	public List<Ticket> getAllTicket(){
		return ticketRepository.findAll();
	}
	public List<Ticket> findAllByClientId(Long idClient) {
		return ticketRepository.findByClientIdClient(idClient);
		
	}
	
	
	public Ticket getTicketById(Long idTicket) {
		return ticketRepository.getById(idTicket);
				
		
	}
	
	public Optional<Ticket> findById(Long idTicket) {
		return ticketRepository.findById(idTicket);
				
		
	}
	
	public Ticket updateTicket(Long id, Ticket ticketUpdate) {
	    Optional<Ticket> optionalTicket = ticketRepository.findById(id);
	    if (!optionalTicket.isPresent()) {
	        throw new IllegalArgumentException("Ticket not found with id: " + id);
	    }

	    Ticket ticket = optionalTicket.get();
	    Date currentDate = new Date();
	    boolean isUpdated = false;

	    // Vérification pour le champ Titre
	    if (!ticket.getTitre().equals(ticketUpdate.getTitre())) {
	        ajouterLogModification(ticket, "Titre", ticket.getTitre(), ticketUpdate.getTitre(), currentDate);
	        ticket.setTitre(ticketUpdate.getTitre());
	        isUpdated = true;
	    }

	    // Vérification pour le champ Description
	    if (!ticket.getDescription().equals(ticketUpdate.getDescription())) {
	        ajouterLogModification(ticket, "Description", ticket.getDescription(), ticketUpdate.getDescription(), currentDate);
	        ticket.setDescription(ticketUpdate.getDescription());
	        isUpdated = true;
	    }

	    // Vérification pour le champ Statut
	    if (!ticket.getStatut().equals(ticketUpdate.getStatut())) {
	        ajouterLogModification(ticket, "Statut", ticket.getStatut().getNom(), ticketUpdate.getStatut().getNom(), currentDate);
	        ticket.setStatut(ticketUpdate.getStatut());
	        isUpdated = true;
	    }

	    // Vérification pour le champ Priorité
	    if (!ticket.getPriorite().equals(ticketUpdate.getPriorite())) {
	        ajouterLogModification(ticket, "Priorité", ticket.getPriorite().getNom(), ticketUpdate.getPriorite().getNom(), currentDate);
	        ticket.setPriorite(ticketUpdate.getPriorite());
	        isUpdated = true;
	    }

	    // Vérification pour l'Application
	    if (ticket.getApplication() != null && ticketUpdate.getApplication() != null &&
	        !ticket.getApplication().equals(ticketUpdate.getApplication())) {
	        ajouterLogModification(ticket, "Application", ticket.getApplication().getNom(), ticketUpdate.getApplication().getNom(), currentDate);
	        ticket.setApplication(ticketUpdate.getApplication());
	        isUpdated = true;
	    }

	    // Vérification pour la Catégorie
	    if (ticket.getCategorie() != null && ticketUpdate.getCategorie() != null &&
	        !ticket.getCategorie().equals(ticketUpdate.getCategorie())) {
	        ajouterLogModification(ticket, "Catégorie", ticket.getCategorie().getNom(), ticketUpdate.getCategorie().getNom(), currentDate);
	        ticket.setCategorie(ticketUpdate.getCategorie());
	        isUpdated = true;
	    }

	    // Vérification pour le Consultant
	    if (ticket.getConsultant() != null && ticketUpdate.getConsultant() != null &&
	        !ticket.getConsultant().equals(ticketUpdate.getConsultant())) {
	        ajouterLogModification(ticket, "Consultant", ticket.getConsultant().getNom(), ticketUpdate.getConsultant().getNom(), currentDate);
	        ticket.setConsultant(ticketUpdate.getConsultant());
	        isUpdated = true;
	    }

	    // Si une modification a été effectuée, sauvegarder le ticket
	    if (isUpdated) {
	        ticket.setDateMaj(currentDate); // Mettre à jour la date de modification uniquement s'il y a un changement
	        return ticketRepository.save(ticket);
	    }
	    
	    return ticket;
	}

	
	private void ajouterLogModification(Ticket ticket, String champ, String ancienneValeur, String nouvelleValeur, Date date) {
	    TicketLog log = new TicketLog();
	    log.setTicket(ticket);
	    log.setAction(champ);
	    log.setValeurPrec(ancienneValeur);
	    log.setValeurSuiv(nouvelleValeur);
	    log.setDate(date);
	    logRepository.save(log);
	}
	
	public List<TicketLog> getLogsByTicketId(Long ticketId) {
	    return logRepository.findByTicketIdTicket(ticketId);
	}
}
