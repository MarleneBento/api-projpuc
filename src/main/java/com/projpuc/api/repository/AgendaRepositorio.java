package com.projpuc.api.repository;


import com.projpuc.api.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepositorio extends JpaRepository<Agenda,Long> {
}
