package com.projpuc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "agenda")
public class Agenda  implements Serializable {
    /* Agenda dos serviços oferecidos, quando cliente nulo o horário está disponível */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String dateHora;
    @OneToOne
    private Servico servico;
    @OneToOne
    private Cliente cliente;
    @Column(name = "compareceu",length = 1)
    private String compareceu;



}
