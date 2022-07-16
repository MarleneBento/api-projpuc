package com.projpuc.api.controller;

import com.projpuc.api.model.Marca;
import com.projpuc.api.service.MarcaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/marca")
public class MarcaControlador {

    @Autowired
    private MarcaServico marcaServico;

    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodos() {
        List<Marca> list = marcaServico.listaTodasMarcas();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Marca> inserirMarca(@RequestBody Marca obj) {
        obj = marcaServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
