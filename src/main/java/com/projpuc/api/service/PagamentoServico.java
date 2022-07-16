package com.projpuc.api.service;

import com.projpuc.api.model.Pagamento;
import com.projpuc.api.repository.PagamentoRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServico {

    @Autowired
    private PagamentoRepositorio repositorio;

    public List<Pagamento> listaTodosPagamentos() {
        return repositorio.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        Optional<Pagamento> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Pagamento atualizar(Long id, Pagamento obj) {
        try {
            Pagamento entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Pagamento inserir(Pagamento obj) {
        return repositorio.save(obj);
    }

    private void updateData(Pagamento entity, Pagamento obj) {
        entity.setDescricao(obj.getDescricao());
    }


}
