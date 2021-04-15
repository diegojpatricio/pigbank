package com.avaliacao.pigbank.transacoes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TIPOTRANSACAO")
public enum TipoTransacao {

    SAQUE, DEPOSITO, TRANSFERIR, EXTRATO;
}
