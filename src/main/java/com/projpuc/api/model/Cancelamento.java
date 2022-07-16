package com.projpuc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cancelamento")
public class Cancelamento {
    /* Registro do cancelamento do agendamento*/
    @ManyToOne
    private Agenda agenda;
    private String data;
    @Column(name = "motivo",length = 255,nullable = true)
    private String motivo;

}
