package com.avaliacao.pigbank.contaCorrente.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTACORRENTE")
public class ContaCorrete {

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
}
