/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
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
                rs.getLong("id"),
                rs.getString("placa"),
                rs.getString("chassi"),
                rs.getString("ano"),
                rs.getString("cor"),
                rs.getFloat("IPVA"),
                rs.getDate("seguro"),
                rs.getDate("garantia"),
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
                    + "valorComprado = " + carro.getValorComprado()+ "', "
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
}
