package com.avaliacao.pigbank.cliente.model;

import com.avaliacao.pigbank.contaCorrente.model.ContaCorrete;
import com.avaliacao.pigbank.contaPoupanca.model.ContaPoupanca;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name="CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column
    private String cpf;
    @Column
    private String cnpj;
    @Column
    private String telefone;
    @Column
    private String email;
    @Column
    private String endereco;
    @Column
    @JoinColumn
    //Ajustar a anotação de Join
    private ContaCorrete contaCorrete;
    @Column
    @JoinColumn
    //Ajustar a anotação de Join
    private ContaPoupanca contaPoupanca;

}
