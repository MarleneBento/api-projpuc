package com.projpuc.api.controller;

import com.projpuc.api.model.Perfil;
import com.projpuc.api.service.PerfilServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilControlador {

    @Autowired
    private PerfilServico perfilServico;

    @GetMapping
    public ResponseEntity<List<Perfil>> buscarTodos() {
        List<Perfil> list = perfilServico.listaTodosPerfis();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Perfil> inserirPerfil(@RequestBody Perfil obj) {
        obj = perfilServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
