package com.projpuc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atendimento")
public class Atendimento implements Serializable {
    /* Cadastro do atendimento ao cliente */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private String datahora;
    private String historico;
    private Boolean resgatePonto;
    @OneToOne
    private Agenda agenda;
    @ManyToOne
    private Pagamento pagamento;

}
