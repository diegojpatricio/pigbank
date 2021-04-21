package com.avaliacao.pigbank.transacoes.repository;

import com.avaliacao.pigbank.transacoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
