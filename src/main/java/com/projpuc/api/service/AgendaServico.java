package com.projpuc.api.service;

import com.projpuc.api.model.Agenda;
import com.projpuc.api.repository.AgendaRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaServico{

    @Autowired
    private AgendaRepositorio repositorio;

    public List<Agenda> listaTodasAgendas() {
        return repositorio.findAll();
    }

    public Agenda buscarPorId(Long id) {
        Optional<Agenda> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Agenda atualizar(Long id, Agenda obj) {
        try {
            Agenda entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Agenda inserir(Agenda obj) {
        return repositorio.save(obj);
    }

    private void updateData(Agenda entity, Agenda obj) {
        entity.setDateHora(obj.getDateHora());
        entity.setServico(obj.getServico());
        entity.setCliente(obj.getCliente());
        entity.setCompareceu(obj.getCompareceu());
    }

}
