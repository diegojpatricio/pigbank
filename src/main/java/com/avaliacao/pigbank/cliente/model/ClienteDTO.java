package com.avaliacao.pigbank.cliente.model;


import java.io.Serializable;



public class ClienteDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cpf;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private String nome;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.cnpj = obj.getCnpj();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.endereco = obj.getEndereco();
        this.nome = obj.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
