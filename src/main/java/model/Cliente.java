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
public class Cliente extends Pessoa {

    public Cliente(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco) {
        super(id, nome, cpf, telefone, endereco, contaBanco);
    }


    public static List<Object> obterClientes() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Cliente.class);
    }

    public static Cliente obterCliente(long codCliente) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Cliente) DAO.findOne(codCliente, Cliente.class);
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
