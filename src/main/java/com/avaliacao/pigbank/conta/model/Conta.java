package com.avaliacao.pigbank.conta.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.transacoes.model.Transacao;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CONTAS")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CONTA")
    private Long id;

    @Column(name="NUMERO_CONTA")
    private String numeroConta;

    @Column(name="AGENCIA")
    private String agencia;

    @Column(name="SALDO")
    private Double saldo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_CONTA")
    private TipoConta tipoConta;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Transacao> transacoes;

    public Conta() {
    }

    public Conta(Long id, String numeroConta, String agencia, Double saldo, Cliente cliente, TipoConta tipoConta, List<Transacao> transacoes) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.transacoes = transacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return id.equals(conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
