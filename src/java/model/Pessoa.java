/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Raphael
 */
public abstract class Pessoa {
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private ContaBanco contaBanco;
    private int idPrimariaEndereco;
    private int idPrimariaContaBanco;
    
    public Pessoa(long id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, int idPrimariaEndereco, int idPrimariaContaBanco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.contaBanco = contaBanco;
        this.idPrimariaEndereco = idPrimariaEndereco;
        this.idPrimariaContaBanco = idPrimariaContaBanco;

    }

    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ContaBanco getContaBanco() {
        return contaBanco;
    }

    public void setContaBanco(ContaBanco contaBanco) {
        this.contaBanco = contaBanco;
    }
}
