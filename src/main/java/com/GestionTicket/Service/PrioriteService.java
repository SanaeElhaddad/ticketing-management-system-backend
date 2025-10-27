package com.GestionTicket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Priorite;
import com.GestionTicket.Repository.PrioriteRepository;

@Service
public class PrioriteService {

	@Autowired
	private PrioriteRepository prioriteRepository;
	
	public List<Priorite> findAllPriorites(){
		return prioriteRepository.findAll();
	}
}
