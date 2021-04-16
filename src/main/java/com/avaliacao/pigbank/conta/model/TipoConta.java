package com.avaliacao.pigbank.conta.model;




public enum TipoConta {
    ContaCorrente("CC"), ContaPoupanca("CP");

    public final String descricao;

    TipoConta(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return getDescricao();
    }
}
