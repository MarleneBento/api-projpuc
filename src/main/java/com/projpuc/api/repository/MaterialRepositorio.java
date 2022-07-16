package com.projpuc.api.repository;

import com.projpuc.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepositorio extends JpaRepository<Perfil,Long> {
}
