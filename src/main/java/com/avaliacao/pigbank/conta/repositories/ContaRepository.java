package com.avaliacao.pigbank.conta.repositories;

import com.avaliacao.pigbank.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

   @Query("SELECT obj FROM Conta obj WHERE obj.cliente.id = :id_cliente")
    List<Conta> buscarClienteId(@Param(value = "id_cliente") Long id_cliente);
}
