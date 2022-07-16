package com.projpuc.api.repository;

import com.projpuc.api.model.Material;
import com.projpuc.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepositorio extends JpaRepository<Material,Long> {
}
