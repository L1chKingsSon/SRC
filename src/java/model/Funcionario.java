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
    private Boolean nivelAcesso;

    public Funcionario(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, long salario, String login, String senha, Boolean nivelAcesso) {
        super(id, nome, cpf, telefone, endereco, contaBanco);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
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
    
    public Boolean getNivelAcesso()
    {
        return nivelAcesso;
    }
    
    public void setNivelAcesso(Boolean nivelAcesso)
    {
        this.nivelAcesso = nivelAcesso;
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
    
    public void excluir() throws ClassNotFoundException, SQLException{
        FuncionarioDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        FuncionarioDAO.alterar(this);
    }
}
