package com.avaliacao.pigbank.transacoes.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.conta.model.Conta;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "HISTORICOTRANSACOES")
public class HistoricosTransacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICOTRANSACAO")
    private Long id;

    @Column(name = "CONTA")
    private Conta conta;

    @Column(name = "CLIENTE")
    private Cliente cliente;

    @Column(name = "MOMENTO_TRANSACAO")
    private Instant momentoTransacao;

    @Column(name = "VALOR_TRANSACAO")
    private Double valorTransacao;

    @Column(name = "TIPO_TRANSACAO")
    private TipoTransacao tipoTransacao;

}
