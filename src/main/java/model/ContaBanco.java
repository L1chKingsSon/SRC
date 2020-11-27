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
public class ContaBanco {
    @Id
    @GeneratedValue

    private long id;
    private String nome;
    private String agencia;
    private String conta;
    private String tipo;

    public ContaBanco(long id, String agencia, String conta, String tipo, String nome) {
        this.id = id;
        this.agencia = agencia;
        this.conta = conta;
        this.tipo = tipo;
        this.nome = nome;
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static List<Object> obterContas() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(ContaBanco.class);
    }

    public static ContaBanco obterConta(long codConta) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (ContaBanco) DAO.findOne(codConta, ContaBanco.class);
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
