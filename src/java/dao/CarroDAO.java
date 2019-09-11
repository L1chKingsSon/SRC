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
import java.util.ArrayList;
import java.util.List;
import model.Carro;

/**
 *
 * @author Raphael
 */
public class CarroDAO {
    
//         public static Carro instanciarCarro(ResultSet rs) throws SQLException {
//        Carro carro = new Carro(rs.getInt("idCarro")),
//                rs.getString("placa"),
//                rs.getString("chassi"),
//                rs.getString("ano"),
//                rs.getString("cor"),
//                rs.getString("IPVA"),
//                rs.getString("seguro"),
//                rs.getString("garantia"),
//                rs.getString("valorComprado"),
//                null);
//                carro.setModelo(rs.getInt("1"));
//                return carro;
//    
//    }
    
    public static List<Carro> obterCarros() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Carro> carros = new ArrayList<Carro>();
        Carro carro = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                carro = instanciarCarro(rs);
                carros.add(carro);
            }
            }   finally {
                fecharConexao(conexao, comando);
                    }
            return carros;
        }
    }
