package com.projpuc.api.service;

import com.projpuc.api.model.Estabelecimento;
import com.projpuc.api.repository.EstabelecimentoRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstabelecimentoServico {

    private EstabelecimentoRepositorio repositorio;

    public List<Estabelecimento> listaTodosEstabelecimentos(){
        return repositorio.findAll();
    }
    public Estabelecimento inserir(Estabelecimento obj){
        return repositorio.save(obj);
    }

}
