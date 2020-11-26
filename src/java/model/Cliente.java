/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Cliente extends Pessoa {

    public Cliente(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco) {
        super(id, nome, cpf, telefone, endereco, contaBanco);
    }


    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterClientes();
    }

    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterCliente(codCliente);
    }

    
     public void gravar() throws ClassNotFoundException, SQLException {
        ClienteDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        ClienteDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        ClienteDAO.alterar(this);
    }
}
