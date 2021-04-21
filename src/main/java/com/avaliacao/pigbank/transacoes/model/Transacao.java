package com.avaliacao.pigbank.transacoes.model;


import com.avaliacao.pigbank.conta.model.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TRANSACOES")
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSACOES")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_TRANASCAO")
    private TipoTransacao tipoTransacao;

    @Column
    private Double valor;

    @Column
    private LocalDateTime dateTime = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "CONTA_ID")
    private Conta conta;



}
