package com.avaliacao.pigbank.conta.Repositories;

import com.avaliacao.pigbank.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    class ContaResouce {
    }
}
