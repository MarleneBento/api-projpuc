package com.projpuc.api.controller;

import com.projpuc.api.model.Servico;
import com.projpuc.api.service.ServicoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/servico")
public class ServicoControlador {

    @Autowired
    private ServicoServico servicoServico;

    @GetMapping
    public ResponseEntity<List<Servico>> buscarTodos() {
        List<Servico> list = servicoServico.listaTodosServicos();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Servico> inserirServico(@RequestBody Servico obj) {
        obj = servicoServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
