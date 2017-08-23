package com.br.felipe.transferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.felipe.transferencia.domain.Conta;

public interface ContaRepository  extends JpaRepository<Conta, Long> {

}
