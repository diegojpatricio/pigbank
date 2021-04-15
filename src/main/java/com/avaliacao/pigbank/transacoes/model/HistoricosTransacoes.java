package com.avaliacao.pigbank.transacoes.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.contaCorrente.model.ContaCorrete;
import com.avaliacao.pigbank.contaPoupanca.model.ContaPoupanca;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "HISTORICOTRANSACOES")
public class HistoricosTransacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_HistoricoTransacao")
    private Long id;
    @Column
    private ContaPoupanca contaPoupanca;
    @Column
    private ContaCorrete contaCorrete;
    @Column
    private Cliente cliente;
    @Column
    private Instant momentoTransacao;
    @Column
    private Double valorTransacao;
    @Column
    private TipoTransacao tipoTransacao;

}
