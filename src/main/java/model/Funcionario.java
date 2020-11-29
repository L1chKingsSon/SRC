/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAO;

import javax.persistence.*;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
@Entity
public class Funcionario extends Pessoa {

    private int salario;
    private String login;
    private String senha;
    private Boolean nivelAcesso;

    public Funcionario(){}

    public Funcionario(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, int salario, String login, String senha, Boolean nivelAcesso) {
        super(id, nome, cpf, telefone, endereco, contaBanco);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
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

    public static List<Object> obterFuncionarios() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Funcionario.class);
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Funcionario) DAO.findOne(codFuncionario, Funcionario.class);
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.delete(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.update(this);
    }
}
