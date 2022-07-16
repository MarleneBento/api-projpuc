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
@Table(name = "material")
public class Material implements Serializable {
    /* Cadastro dos materiais para execução dos serviços */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "descricao",length = 255,nullable = true)
    private String descricao;
    private Marca marca;
    private Long quantidade;
    private Double custo;
    private Long estoque;


}
