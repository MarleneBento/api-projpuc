package com.projpuc.api.service;

import com.projpuc.api.model.Perfil;
import com.projpuc.api.repository.PerfilRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServico {
    @Autowired
    private PerfilRepositorio repositorio;

    public List<Perfil> listaTodosPerfis() {
        return repositorio.findAll();
    }

    public Perfil buscarPorId(Long id) {
        Optional<Perfil> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Perfil atualizar(Long id, Perfil obj) {
        try {
            Perfil entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Perfil inserir(Perfil obj) {
        return repositorio.save(obj);
    }

    private void updateData(Perfil entity, Perfil obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }
}
