package com.avaliacao.pigbank.cliente.model;

import com.avaliacao.pigbank.conta.model.Conta;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientPersist {

    @NotNull
    @Size(max =11, min =11)
    private String cpf;

    @NotNull
    private String email;

    @NotNull
    private String telefone;

    @NotNull
    private String nome;

    @NotNull
    List<Conta> contas;

}
