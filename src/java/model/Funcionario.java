/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Funcionario extends Pessoa {

    private float salario;
    private String login;
    private String senha;

    public Funcionario(int id, String nome, String cpf, String telefone, int idPrimariaEndereco, int idPrimariaContaBanco, long salario, String login, String senha) {
        super(id, nome, cpf, telefone, idPrimariaEndereco, idPrimariaContaBanco);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public float getSalario() {
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

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(codFuncionario);
    }

    public void gravar()
            throws 
            ClassNotFoundException,
            SQLException {
        FuncionarioDAO.gravar(this);
    }
}
