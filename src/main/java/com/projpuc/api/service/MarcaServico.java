package com.projpuc.api.service;

import com.projpuc.api.model.Marca;
import com.projpuc.api.repository.MarcaRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaServico {

    @Autowired
    private MarcaRepositorio repositorio;

    public List<Marca> listaTodasMarcas() {
        return repositorio.findAll();
    }

    public Marca buscarPorId(Long id) {
        Optional<Marca> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Marca atualizar(Long id, Marca obj) {
        try {
            Marca entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Marca inserir(Marca obj) {
        return repositorio.save(obj);
    }

    private void updateData(Marca entity, Marca obj) {
        entity.setDescricao(obj.getDescricao());
    }
}
