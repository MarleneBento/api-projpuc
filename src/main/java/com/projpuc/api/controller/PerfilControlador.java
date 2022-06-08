package com.projpuc.api.controller;

import com.projpuc.api.model.Perfil;
import com.projpuc.api.service.PerfilServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilControlador {

    @Autowired
    private PerfilServico perfilServico;

    @GetMapping
    public ResponseEntity<List<Perfil>> buscarTodos(){
        List<Perfil> list  = perfilServico.listaTodosPerfis();
        return ResponseEntity.ok().body(list);
    }
}
