package com.avaliacao.pigbank.conta.model;

import com.avaliacao.pigbank.cliente.model.Cliente;

import java.io.Serializable;


public class ContaDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String numeroConta;
    private String agencia;
    private Double saldo;
    private Cliente cliente;
    private TipoConta tipoConta;

    public ContaDTO() {
    }

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.numeroConta = conta.getNumeroConta();
        this.agencia = conta.getAgencia();
        this.saldo = conta.getSaldo();
        this.cliente = conta.getCliente();
        this.tipoConta = conta.getTipoConta();
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


}
