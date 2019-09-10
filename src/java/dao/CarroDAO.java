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
