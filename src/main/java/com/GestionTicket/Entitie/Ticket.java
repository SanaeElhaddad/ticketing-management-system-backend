package com.GestionTicket.Entitie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Ticket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String titre;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idStatut")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "idPriorite")
    private Priorite priorite;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idAgent")
    private Agent consultant;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;

    @ManyToOne
    @JoinColumn(name = "idApplication")
    private Application application;

    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TicketLog> ticketLogs=new ArrayList<>();

//    @OneToMany(mappedBy = "ticket")
//    private List<Comment> comments;
//


	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public List<TicketLog> getTicketLogs() {
		return ticketLogs;
	}

	public void setTicketLogs(List<TicketLog> ticketLogs) {
		this.ticketLogs = ticketLogs;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Agent getConsultant() {
		return consultant;
	}

	public void setConsultant(Agent consultant) {
		this.consultant = consultant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	
	@Override
    public String toString() {
        return "titre='" + titre + '\'' +
               ", description='" + description + '\'' +
               ", dateCreation=" + dateCreation +
               ", dateMaj=" + dateMaj +
               ", dateLivraison=" + dateLivraison +
               ", statut=" + (statut != null ? statut.getNom() : "null") +
               ", priorite=" + (priorite != null ? priorite.getNom() : "null") +
               ", categorie=" + (categorie != null ? categorie.getNom() : "null") +
               ", application=" + (application != null ? application.getNom() : "null") +
               ' ';
    }
    
    
}
