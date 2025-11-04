package com.desafio.gerenciador_boletos.controller;

import com.desafio.gerenciador_boletos.DTO.BoletoDTO;
import com.desafio.gerenciador_boletos.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletos")
public class boletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping
    public ResponseEntity<List<BoletoDTO>> listarBoletos() {
        List<BoletoDTO> boletos = boletoService.listarBoletos();
        return new ResponseEntity<>(boletos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoletoDTO> criarBoleto(@RequestBody BoletoDTO boletoDTO) {
        BoletoDTO novoBoleto = boletoService.criarBoleto(boletoDTO);
        return new ResponseEntity<>(novoBoleto, HttpStatus.CREATED);
    }
}
