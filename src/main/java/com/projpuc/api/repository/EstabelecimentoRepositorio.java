package com.projpuc.api.repository;

import com.projpuc.api.model.Estabelecimento;
import com.projpuc.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepositorio extends JpaRepository<Estabelecimento,Long> {
}
