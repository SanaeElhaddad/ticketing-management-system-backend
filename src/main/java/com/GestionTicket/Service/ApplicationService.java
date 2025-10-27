package com.GestionTicket.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionTicket.Entitie.Application;
import com.GestionTicket.Repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	public List<Application> getAllApplication(){
		return applicationRepository.findAll();
	}
	
	public Optional<Application> findById(Long id) {
		return applicationRepository.findById(id);
	}
	
	public Application getApplicationById(Long id) {
		return applicationRepository.getById(id);
	}
}
