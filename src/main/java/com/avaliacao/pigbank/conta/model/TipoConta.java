package com.avaliacao.pigbank.conta.model;



public enum TipoConta {

    CC("ContaCorrente"), CP("ContaPoupanca");

    private String descricao;

   TipoConta(final String descricao) {
       this.descricao = descricao;
   }

   public String getDescricao(){
        return descricao;
    }
}
