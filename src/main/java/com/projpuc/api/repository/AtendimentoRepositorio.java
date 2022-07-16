package com.projpuc.api.repository;

import com.projpuc.api.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepositorio extends JpaRepository<Atendimento,Long> {
}
