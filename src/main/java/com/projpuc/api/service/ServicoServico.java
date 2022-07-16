package com.projpuc.api.service;

import com.projpuc.api.model.Servico;
import com.projpuc.api.repository.ServicoRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoServico {
    @Autowired
    private ServicoRepositorio repositorio;

    public List<Servico> listaTodosServicos() {
        return repositorio.findAll();
    }

    public Servico buscarPorId(Long id) {
        Optional<Servico> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Servico atualizar(Long id, Servico obj) {
        try {
            Servico entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Servico inserir(Servico obj) {
        return repositorio.save(obj);
    }

    private void updateData(Servico entity, Servico obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setValor(obj.getValor());
        entity.setPontos(obj.getPontos());
        entity.setTempoServico(obj.getTempoServico());
        entity.setFotoModelo(obj.getFotoModelo());
    }

}
