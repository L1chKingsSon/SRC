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
import model.Endereco;
import model.Marca;

/**
 *
 * @author Raphael
 */
public class EnderecoDAO {

    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<Endereco>();
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while (rs.next()) {
                endereco = instanciarEndereco(rs);
                enderecos.add(endereco);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    public static Endereco obterEndereco(int codEndereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from endereco where id = " + codEndereco);
            rs.first();
            endereco = instanciarEndereco(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return endereco;
    }

    public static Endereco instanciarEndereco(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco(
                rs.getLong("id"),
                rs.getString("cep"),
                rs.getString("uf"),
                rs.getString("cidade"),
                rs.getString("bairro"),
                rs.getString("logadouro"),
                rs.getString("numero"),
                rs.getString("complement0")
        );
        return endereco;
    }
    
        public static void gravar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into endereco (id, cep, uf, cidade, bairro, "
                    + "logradouro, numero, complemento) "
                    + "values (?,?,?,?,?,?,?,?)");
            comando.setLong(1, endereco.getId());
            comando.setString(2, endereco.getCep());
            comando.setString(3, endereco.getUf());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getBairro());
            comando.setString(6, endereco.getLogradouro());
            comando.setString(7, endereco.getNumero());
            comando.setString(8, endereco.getComplemento());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update endereco set cep = '" + endereco.getCep() + "', "
                    + "uf = '" + endereco.getUf() + "', "
                    + "cidade = '" + endereco.getCidade() + "', "
                    + "bairro = '" + endereco.getBairro() + "', "
                    + "logradouro = '" + endereco.getLogradouro() + "', "
                    + "numero = '" + endereco.getNumero() + "', "
                    + "complemento = '" + endereco.getComplemento() + "'";
            stringSQL = stringSQL + "where id = " + endereco.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        
        public static void excluir(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from endereco where id ="
                    + endereco.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
