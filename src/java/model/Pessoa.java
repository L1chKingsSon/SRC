/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Raphael
 */
public abstract class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private ContaBanco contaBanco;
    private int idPrimariaEndereco;
    private int idPrimariaContaBanco;

    public Pessoa(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.contaBanco = contaBanco;

    }

    public int getIdPrimariaEndereco() throws ClassNotFoundException, SQLException {
        return idPrimariaEndereco;
    }

    public void setIdPrimariaEndereco(int idPrimariaEndereco) {
        this.idPrimariaEndereco = idPrimariaEndereco;
    }

    public int getIdPrimariaContaBanco() {
        return idPrimariaContaBanco;
    }

    public void setIdPrimariaContaBanco(int idPrimariaContaBanco) {
        this.idPrimariaContaBanco = idPrimariaContaBanco;
    }

    public Endereco getEndereco() throws ClassNotFoundException, SQLException {
        if((this.idPrimariaEndereco != 0) && (this.endereco == null)){
            this.endereco = Endereco.obterEndereco(idPrimariaEndereco);
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public ContaBanco getContaBanco() throws ClassNotFoundException, SQLException {
        if((this.idPrimariaContaBanco != 0) && (this.contaBanco == null)){
            this.contaBanco = ContaBanco.obterConta(idPrimariaContaBanco);
        }
        return contaBanco;
    }

    public void setContaBanco(ContaBanco contaBanco) {
        this.contaBanco = contaBanco;
    }
}
