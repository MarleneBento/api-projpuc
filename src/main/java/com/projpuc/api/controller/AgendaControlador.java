package com.projpuc.api.controller;

import com.projpuc.api.model.Agenda;
import com.projpuc.api.service.AgendaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaControlador {

    @Autowired
    private AgendaServico agendaServico;

    @GetMapping
    public ResponseEntity<List<Agenda>> buscarTodos() {
        List<Agenda> list = agendaServico.listaTodasAgendas();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping
    public ResponseEntity<Agenda> inserirAgenda(@RequestBody Agenda obj) {
        obj = agendaServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
