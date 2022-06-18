package com.projpuc.api.service;

import com.projpuc.api.model.Estabelecimento;
import com.projpuc.api.repository.EstabelecimentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoServico {
    @Autowired
    private EstabelecimentoRepositorio repositorio;

    public List<Estabelecimento> listaTodosEstabelecimentos() {
        return repositorio.findAll();
    }

    public Estabelecimento inserir(Estabelecimento obj) {
        return repositorio.save(obj);
    }

}
