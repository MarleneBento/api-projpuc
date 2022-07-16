package com.projpuc.api.service;

import com.projpuc.api.model.Atendimento;
import com.projpuc.api.repository.AtendimentoRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoServico {

    @Autowired
    private AtendimentoRepositorio repositorio;

    public List<Atendimento> listaTodosAtendimentos() {
        return repositorio.findAll();
    }

    public Atendimento buscarPorId(Long id) {
        Optional<Atendimento> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Atendimento atualizar(Long id, Atendimento obj) {
        try {
            Atendimento entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Atendimento inserir(Atendimento obj) {
        return repositorio.save(obj);
    }

    private void updateData(Atendimento entity, Atendimento obj) {
        entity.setDatahora(obj.getDatahora());
        entity.setHistorico(obj.getHistorico());
        entity.setResgatePonto(obj.getResgatePonto());
        entity.setAgenda(obj.getAgenda());
        entity.setPagamento(obj.getPagamento());
    }


}
