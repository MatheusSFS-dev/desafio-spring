package com.desafio.gerenciador_boletos.repository;

import com.desafio.gerenciador_boletos.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {

}
