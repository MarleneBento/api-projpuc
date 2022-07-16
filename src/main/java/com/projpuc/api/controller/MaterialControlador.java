package com.projpuc.api.controller;

import com.projpuc.api.model.Material;
import com.projpuc.api.service.MaterialServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/material")
public class MaterialControlador {

    @Autowired
    private MaterialServico materialServico;

    @GetMapping
    public ResponseEntity<List<Material>>buscarTodos() {
        List<Material> list = materialServico.listaTodosMateriais();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Material> inserirMaterial(@RequestBody Material obj) {
        obj = materialServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
ma