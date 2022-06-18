package com.projpuc.api.service;

import com.projpuc.api.model.Perfil;
import com.projpuc.api.repository.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfilServico {
    @Autowired
    private PerfilRepositorio repositorio;

    public List<Perfil>listaTodosPerfis() {
        return repositorio.findAll();
    }
    public Perfil inserir(Perfil obj){
        return repositorio.save(obj);
    }
}
