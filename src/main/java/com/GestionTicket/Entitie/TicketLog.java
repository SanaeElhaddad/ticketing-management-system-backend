package com.GestionTicket.Entitie;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TicketLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketLogId;

    @ManyToOne
    @JoinColumn(name = "idTicket")
    @JsonBackReference
    private Ticket ticket;

    private String action;
    private String valeurPrec;
    private String valeurSuiv;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

	public Long getTicketLogId() {
		return ticketLogId;
	}

	public void setTicketLogId(Long ticketLogId) {
		this.ticketLogId = ticketLogId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValeurPrec() {
		return valeurPrec;
	}

	public void setValeurPrec(String valeurPrec) {
		this.valeurPrec = valeurPrec;
	}

	public String getValeurSuiv() {
		return valeurSuiv;
	}

	public void setValeurSuiv(String valeurSuiv) {
		this.valeurSuiv = valeurSuiv;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
