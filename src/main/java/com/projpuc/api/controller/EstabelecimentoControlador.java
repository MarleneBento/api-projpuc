package com.projpuc.api.controller;

import com.projpuc.api.model.Estabelecimento;
import com.projpuc.api.service.EstabelecimentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoControlador {
    @Autowired
    private EstabelecimentoServico estabelecimentoServico;

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> buscarTodos() {
        List<Estabelecimento> list = estabelecimentoServico.listaTodosEstabelecimentos();
        return ResponseEntity.ok().body(list);
    }
}
