package com.GestionTicket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Statut;
import com.GestionTicket.Repository.StatutRepository;

@Service
public class StatutService {

	@Autowired
	private StatutRepository statutRepository;
	
	public List<Statut> findAllStatuts(){
		return statutRepository.findAll();
	}
}
