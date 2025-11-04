package com.desafio.gerenciador_boletos.DTO;


import lombok.Data;

@Data
public class BoletoDTO {
    private Long id;
    private String emitente;
    private Double valor;
    private Boolean pago;
}

