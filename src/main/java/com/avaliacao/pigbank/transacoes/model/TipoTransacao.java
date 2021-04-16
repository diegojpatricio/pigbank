package com.avaliacao.pigbank.transacoes.model;


public enum TipoTransacao {

    SAQUE("S"), DEPOSITO("D"), TRANSFERIR("T"), EXTRATO("E");

    private final String transacao;

    TipoTransacao(final String transacao) {
        this.transacao = transacao;
    }

    public String getTransacao(){
        return getTransacao();
    }
}
