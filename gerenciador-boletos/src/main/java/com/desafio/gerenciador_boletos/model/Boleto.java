package com.desafio.gerenciador_boletos.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "boleto")
@Data
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String emitente;
    private Double valor;
    private Boolean pago;
}
