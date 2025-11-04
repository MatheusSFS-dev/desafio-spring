package com.desafio.gerenciador_boletos.service;

import com.desafio.gerenciador_boletos.DTO.BoletoDTO;
import com.desafio.gerenciador_boletos.model.Boleto;
import com.desafio.gerenciador_boletos.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;


    public List<BoletoDTO> listarBoletos() {
        List<Boleto> boletos = boletoRepository.findAll();
        return boletos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public BoletoDTO criarBoleto(BoletoDTO boletoDTO) {
        Boleto boleto = convertToEntity(boletoDTO);
        Boleto boletoSalvo = boletoRepository.save(boleto);
        return convertToDTO(boletoSalvo);
    }

    private BoletoDTO convertToDTO(Boleto boleto) {
        BoletoDTO boletoDTO = new BoletoDTO();
        boletoDTO.setId(boleto.getId());
        boletoDTO.setEmitente(boleto.getEmitente());
        boletoDTO.setValor(boleto.getValor());
        boletoDTO.setPago(boleto.getPago());
        return boletoDTO;
    }

    private Boleto convertToEntity(BoletoDTO boletoDTO) {
        Boleto boleto = new Boleto();
        boleto.setId(boletoDTO.getId());
        boleto.setEmitente(boletoDTO.getEmitente());
        boleto.setValor(boletoDTO.getValor());
        boleto.setPago(boletoDTO.getPago());
        return boleto;
    }
}
