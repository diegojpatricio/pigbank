package com.avaliacao.pigbank.contaPoupanca.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CONTAPOUPANCA")
public class ContaPoupanca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contaCorrente")
    private Long id;
    @Column
    private String numeroConta;
    @Column
    private String agencia;
    @Column
    private Double saldo;
    @Column
    private Cliente cliente;

    //Verificar se essa constante JUROS será utilizada em outras classe.
    //para que seja retirado o FINAL
    private static final Double juros = 0.02;
}
