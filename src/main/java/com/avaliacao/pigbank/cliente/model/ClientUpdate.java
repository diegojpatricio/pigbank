package com.avaliacao.pigbank.cliente.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ClientUpdate {

    @NotNull
    private String nome;

    @NotNull
    private String email;


    private String telefone;
}
