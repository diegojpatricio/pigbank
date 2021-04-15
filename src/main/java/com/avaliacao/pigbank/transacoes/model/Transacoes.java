package com.avaliacao.pigbank.transacoes.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.contaCorrente.model.ContaCorrete;
import com.avaliacao.pigbank.contaPoupanca.model.ContaPoupanca;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TRANSACOES")
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacoes")
    private Long id;
    @Column
    private ContaCorrete contaCorrete;
    @Column
    private ContaPoupanca contaPoupanca;
    @Column
    private Cliente cliente;
    @Column
    private TipoTransacao tipoTransacao;

    public void depositar(){}
    public void sacar(){}
    public void transferir(){}
    public void extrato(){}
}
