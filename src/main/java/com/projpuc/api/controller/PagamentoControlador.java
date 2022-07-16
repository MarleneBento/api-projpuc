package com.projpuc.api.controller;

import com.projpuc.api.model.Pagamento;
import com.projpuc.api.service.PagamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoControlador {

    @Autowired
    private PagamentoServico pagamentoServico;

    @GetMapping
    public ResponseEntity<List<Pagamento>> buscarTodos() {
        List<Pagamento> list = pagamentoServico.listaTodosPagamentos();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Pagamento> inserirPagamento(@RequestBody Pagamento obj) {
        obj = pagamentoServico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.
                        getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
