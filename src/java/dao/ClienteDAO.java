/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author jafar
 */
public class ClienteDAO {

    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public static Cliente instanciarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                null,
                null);
        cliente.setIdPrimariaEndereco(rs.getInt("id_endereco"));
        cliente.setIdPrimariaContaBanco(rs.getInt("id_Conta_Banco"));
        return cliente;
    }

    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente where id = " + codCliente);
            rs.first();
            cliente = instanciarCliente(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
    }
    
    public static void gravar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into cliente(id, nome, cpf, telefone, id_Conta_Banco, id_Endereco) "
                    + "values (?,?, ?, ?, ?, ?)");
            comando.setLong(1, cliente.getId());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getTelefone());
            comando.setLong(5, cliente.getContaBanco().getId());
            comando.setLong(6, cliente.getEndereco().getId());
            
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(Cliente cliente) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update cliente set "
                    + "nome = '" + cliente.getNome() + "', "
                    + "CPF = '" + cliente.getCpf() +  "', "
                    + "telefone = '" + cliente.getTelefone() + "', ";
            if(cliente.getContaBanco() == null)
            {
                stringSQL += "id_Conta_Banco = null, ";
            }
            else
            {
                stringSQL += "id_Conta_Banco = '" + cliente.getContaBanco().getId() + "', ";
            }
            if(cliente.getEndereco() == null)
            {
                stringSQL += "id_Endereco = null";
            }
            else
            {
                stringSQL += "id_Endereco = '" + cliente.getEndereco().getId() + "'";
            }
            stringSQL += " where id = " + cliente.getId() + ";";
            comando.execute(stringSQL);
            
        } finally
            {
                fecharConexao(conexao, comando);
            }
    }
        
        public static void excluir(Cliente cliente) throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    String stringSQL;
    
    try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        stringSQL = "delete from cliente where id="
                + cliente.getId();
        comando.execute(stringSQL);
    } finally
    {
        fecharConexao(conexao, comando);
    }
    
    }
}

