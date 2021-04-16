package com.avaliacao.pigbank.conta.model;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.transacoes.model.Transacoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "conta")
    private List<Transacoes> transacoes;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
