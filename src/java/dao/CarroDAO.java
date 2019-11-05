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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Carro;

/**
 *
 * @author Raphael
 */
public class CarroDAO {

    public static List<Carro> obterCarros() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Carro> carros = new ArrayList<Carro>();
        Carro carro = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while (rs.next()) {
                carro = instanciarCarro(rs);
                carros.add(carro);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return carros;
    }

    public static Carro instanciarCarro(ResultSet rs) throws SQLException {
        Carro carro = new Carro(
                rs.getInt("id"),
                rs.getString("placa"),
                rs.getString("chassi"),
                rs.getString("ano"),
                rs.getString("cor"),
                rs.getFloat("IPVA"),
                rs.getString("seguro"),
                rs.getString("garantia"),
                rs.getDouble("valorComprado"),
                rs.getDouble("valorVenda"),
                null
        );
        carro.setIdPrimariaModelo(rs.getInt("id_Modelo"));
        return carro;
    }

    public static Carro obterCarro(int codCarro) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Carro carro = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from carro where id =" + codCarro);
            rs.first();
            carro = instanciarCarro(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return carro;
    }
    
        public static void alterar(Carro carro) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update carro set "
                    + "cor = '" + carro.getCor() + "', "
                    + "placa = '" + carro.getPlaca() + "', "
                    + "chassi = '" + carro.getChassi() + "', "
                    + "ano = '" + carro.getAno() + "', "
                    + "IPVA = '" + carro.getIPVA()+ "', "
                    + "seguro = '" + carro.getSeguro()+ "', "
                    + "garantia = '" + carro.getGarantia()+ "', "
                    + "valorComprado = '" + carro.getValorComprado()+ "', "
                    + "id_Modelo =";
            if(carro.getModelo() == null){
                stringSQL += null;
            } else {
                stringSQL += carro.getModelo().getId();
            }
            stringSQL = stringSQL + "where id = " + carro.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void gravar(Carro carro) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into carro (id, cor, placa, chassi, ano, IPVA, seguro, garantia, valorComprado, id_Modelo, id_Estacionamento, valorVenda) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, carro.getId());
            comando.setString(2, carro.getCor());
            comando.setString(3, carro.getPlaca());
            comando.setString(4, carro.getChassi());
            comando.setString(5, carro.getAno());
            comando.setFloat(6, carro.getIPVA());
            comando.setString(7, carro.getSeguro());
            comando.setString(8, carro.getGarantia());
            comando.setDouble(9, carro.getValorComprado());
            comando.setInt(10, carro.getModelo().getId());
            comando.setString(11, carro.getCor());
            comando.setString(12, carro.getCor());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void excluir(Carro carro) throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    String stringSQL;
    
    try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        stringSQL = "delete from carro where id="
                + carro.getId();
        comando.execute(stringSQL);
    } finally
    {
        fecharConexao(conexao, comando);
    }
    
    }

}
