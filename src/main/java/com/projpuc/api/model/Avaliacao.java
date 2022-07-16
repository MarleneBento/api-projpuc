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
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {
    /* Cadastro de avaliação do atendimento  - exemplo: nota de 1 a 10*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "comentario",length = 255,nullable = false)
    private String comentario;
    private int nota;

}
