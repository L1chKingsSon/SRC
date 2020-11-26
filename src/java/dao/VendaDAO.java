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
import model.Venda;

/**
 *
 * @author Raphael
 */
public class VendaDAO {
     public static List<Venda> obterVendas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Venda> vendas = new ArrayList<Venda>();
        Venda venda = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda");
            while (rs.next()) {
                venda = instanciarVenda(rs);
                vendas.add(venda);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vendas;
    }

    public static Venda instanciarVenda(ResultSet rs) throws SQLException {
        Venda venda = new Venda(rs.getInt("id"),
                null);
        venda.setIdPrimariaCarro(rs.getInt("id_carro"));
        return venda;
    }

    public static Venda obterVenda(int codVenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda where id = " + codVenda);
            rs.first();
            venda = instanciarVenda(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return venda;
    }
    
    public static void gravar(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into venda(id, id_carro) "
                    + "values (?,?)");
            comando.setLong(1, venda.getId());
            comando.setLong(2, venda.getCarro().getId());
            
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(Venda venda) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update venda set ";
            if(venda.getCarro() == null)
            {
                stringSQL += "id_carro = null";
            }
            else
            {
                stringSQL += "id_carro = '" + venda.getCarro().getId() + "'";
            }
            
            stringSQL += " where id = " + venda.getId() + ";";
            comando.execute(stringSQL);
            
        } finally
            {
                fecharConexao(conexao, comando);
            }
    }
        
        public static void excluir(Venda venda) throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    String stringSQL;
    
    try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        stringSQL = "delete from venda where id="
                + venda.getId();
        comando.execute(stringSQL);
    } finally
    {
        fecharConexao(conexao, comando);
    }
    
    }
}
