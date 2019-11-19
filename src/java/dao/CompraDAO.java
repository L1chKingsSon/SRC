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
import model.Compra;

/**
 *
 * @author Raphael
 */
public class CompraDAO {
     public static List<Compra> obterCompras() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Compra> compras = new ArrayList<Compra>();
        Compra compra = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from compra");
            while (rs.next()) {
                compra = instanciarCompra(rs);
                compras.add(compra);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return compras;
    }

    public static Compra instanciarCompra(ResultSet rs) throws SQLException {
        Compra compra = new Compra(rs.getInt("id"),
                null);
        compra.setIdPrimariaCarro(rs.getInt("id_carro"));
        return compra;
    }

    public static Compra obterCompra(int codCompra) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Compra compra = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from compra where id = " + codCompra);
            rs.first();
            compra = instanciarCompra(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return compra;
    }
    
    public static void gravar(Compra compra) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into compra(id, id_carro) "
                    + "values (?,?)");
            comando.setLong(1, compra.getId());
            comando.setLong(2, compra.getCarro().getId());
            
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(Compra compra) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update compra set ";
            if(compra.getCarro() == null)
            {
                stringSQL += "id_carro = null";
            }
            else
            {
                stringSQL += "id_carro = '" + compra.getCarro().getId() + "'";
            }
            
            stringSQL += " where id = " + compra.getId() + ";";
            comando.execute(stringSQL);
            
        } finally
            {
                fecharConexao(conexao, comando);
            }
    }
        
        public static void excluir(Compra compra) throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    String stringSQL;
    
    try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        stringSQL = "delete from compra where id="
                + compra.getId();
        comando.execute(stringSQL);
    } finally
    {
        fecharConexao(conexao, comando);
    }
    
    }
}
