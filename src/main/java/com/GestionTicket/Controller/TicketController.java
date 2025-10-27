package com.GestionTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Ticket;
import com.GestionTicket.Entitie.TicketLog;
import com.GestionTicket.Service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
//	@PostMapping("/ticket/add")
//	public Ticket addTicket(@RequestBody Ticket ticket,@RequestParam Long statutId) {		
//		return service.addTicketTest(ticket,);
//	}
	
	@PostMapping("/ticket/add")
	public ResponseEntity<Ticket> addTicket(
	        @RequestParam Long idClient,
	        @RequestParam Long idStatut,
	        @RequestParam(required = false) Long idPriorite,
	        @RequestParam(required = false) Long idCategorie,
	        @RequestParam(required = false) Long idApplication,
	        @RequestBody Ticket ticket) {

	    
	    System.out.println("idClient: " + idClient);
	    System.out.println("idStatut: " + idStatut);
	    System.out.println("idPriorite: " + idPriorite);
	    System.out.println("idCategorie: " + idCategorie);
	    System.out.println("idApplication: " + idApplication);

	    return ResponseEntity.ok(ticket);
	}
	
	@PostMapping("/ticket/save")
	public Ticket ajoutTicket(@RequestBody Ticket request) {
	    // Log ou déboguer pour vérifier les paramètres reçus
	    System.out.println("idClient: " + request.getClient().getIdClient());
	    System.out.println("idStatut: " + request.getStatut().getIdStatut());
	    System.out.println("idPriorite: " + request.getPriorite().getIdPriorite());
	    System.out.println("idCategorie: " + request.getCategorie().getIdCategorie());
	    System.out.println("idApplication: " + request.getApplication().getIdApplication());
       return service.addTicketTest(request);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTicket() {
		return service.getAllTicket();
	}
	
	@GetMapping("/tickets/{idClient}")
	public List<Ticket> getAllTicketByClient(@PathVariable Long idClient) {
		return service.findAllByClientId(idClient);
	}
	
	@GetMapping("/ticket/{idTicket}")
	public Ticket getTicketById(@PathVariable Long idTicket) {
		return service.getTicketById(idTicket);
	}
	
	@PutMapping("/ticket/edit/{idTicket}")
    public Ticket updateTicket(@PathVariable Long idTicket, @RequestBody Ticket ticketUpdate) {
        return service.updateTicket(idTicket, ticketUpdate);
        
    }
	
	@GetMapping("/ticket/logs/{idTicket}")
    public ResponseEntity<List<TicketLog>> getLogsByTicketId(@PathVariable Long idTicket) {
        List<TicketLog> logs = service.getLogsByTicketId(idTicket);
        return ResponseEntity.ok(logs);
    }
	

}
