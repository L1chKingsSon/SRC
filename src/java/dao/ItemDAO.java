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
import model.Item;

/**
 *
 * @author jafar
 */
public class ItemDAO {

    public static List<Item> obterItems() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Item> itens = new ArrayList<Item>();
        Item item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from itens");
            while (rs.next()) {
                item = instanciarItem(rs);
                itens.add(item);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return itens;
    }

    public static Item instanciarItem(ResultSet rs) throws SQLException {
        Item item = new Item(
                rs.getInt("id"),
                null,
                null);
        item.setIdPrimariaNotaFiscal(rs.getInt("NotaFiscal_id"));
        item.setIdPrimariaCarro(rs.getInt("id_Carro"));
        return item;
    }

    public static Item obterItem(int codItem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Item item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itens where id =" + codItem);
            rs.first();
            item = instanciarItem(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return item;
    }

    public static void gravar(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into itens (id, NotaFiscal_id, id_Carro) "
                    + "values (?,?,?)");
            comando.setLong(1, item.getId());
            comando.setLong(2, item.getNotaFiscal().getId());
            comando.setLong(3, item.getCarro().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update itens set NotaFiscal_id = '";
            if(item.getNotaFiscal()== null){
                stringSQL += "NotaFiscal_id = null";
            } else {
                stringSQL += "id_Marca = '" + item.getNotaFiscal().getId() + "'";
            } if (item.getCarro() == null){
                stringSQL += "id_Carro = null";
            } else {
                stringSQL += "NotaFiscal_id = '" + item.getCarro().getId() + "'";
            }
            stringSQL += " where id = " + item.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void excluir(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itens where id ="
                    + item.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
