package com.avaliacao.pigbank.cliente.model;

import com.avaliacao.pigbank.conta.model.Conta;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "NOME_CLIENTE")
    private String nome;

    @OneToMany(mappedBy = "cliente")
    @Column(name = "NOME_CLIENTE")
    private List<Conta> conta;



}
