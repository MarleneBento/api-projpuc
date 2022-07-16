package com.projpuc.api.controller;

import com.projpuc.api.model.Atendimento;
import com.projpuc.api.service.AtendimentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/atendimento")
public class AtendimentoControlador {

    @Autowired
    private AtendimentoServico atendimentoServico;

    @GetMapping
    public ResponseEntity<List<Atendimento>> buscarTodos() {
        List<Atendimento> list = atendimentoServico.listaTodosAtendimentos();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Atendimento> inserirAtendimento(@RequestBody Atendimento obj) {
        obj = atendimentoServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
