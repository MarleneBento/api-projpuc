package com.projpuc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estabelecimento")
public class Estabelecimento implements Serializable {
    /* Cadastro do Estabelecimento do administrador */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private  Administrador administrador;
    @Column(name = "nome",length = 255,nullable = true)
    private String nome;
    @Column(name = "informacoes",length = 255,nullable = true)
    private String informacoes;
    @Column(name = "localizacao",length = 255,nullable = true)
    private String localizacao;



}
