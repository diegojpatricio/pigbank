package com.avaliacao.pigbank.transacoes.model;


import com.avaliacao.pigbank.conta.model.Conta;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TRANSACOES")
public class Transacoes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSACOES")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CONTA_ID")
    private Conta conta;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_TRANASCAO")
    private TipoTransacao tipoTransacao;

    public void depositar(){}
    public void sacar(){}
    public void transferir(){}
    public void extrato(){}
}
