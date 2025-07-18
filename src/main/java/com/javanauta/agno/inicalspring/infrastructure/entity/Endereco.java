package com.javanauta.agno.inicalspring.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento", length = 50)
    private String complemento;

    @Column(name = "cidade", length = 40)
    private String cidade;

    @Column(name = "estado" , length = 2)
    private String estado;

    @Column(name = "cep", length = 9)
    private String cep;
}
