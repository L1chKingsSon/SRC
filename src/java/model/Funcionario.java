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
public class Funcionario extends Pessoa{
    private long salario;
    private String login;
    private String senha;

    public Funcionario(long id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, int idPrimariaEndereco, int idPrimariaContaBanco, long salario, String login, String senha) {
        super(id, nome, cpf, telefone, endereco, contaBanco, idPrimariaEndereco, idPrimariaContaBanco);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
