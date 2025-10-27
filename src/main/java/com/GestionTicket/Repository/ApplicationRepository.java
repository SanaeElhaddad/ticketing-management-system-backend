package com.GestionTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionTicket.Entitie.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
