package com.projpuc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Perfil{
    /* Cadastro do interesse do cliente*/
    @Column(name = "interesse",length = 255,nullable = true)
    private String interesse;

}
