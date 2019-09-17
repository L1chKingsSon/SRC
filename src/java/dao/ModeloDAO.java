package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Modelo;

/**
 *
 * @author Alisson
 */
public class ModeloDAO {


    public static List<Modelo> obterModelo() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Modelo> modelos = new ArrayList<Modelo>();
        Modelo modelo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                modelo = instanciarModelo(rs);
                modelos.add(modelo);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return modelos;
    }
    
    public static Modelo obterModelo(int codModelo) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        Modelo modelo = null;
        try
        {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from modelo where id = "+ codModelo);
            rs.first();
            modelo = instanciarModelo(rs);
        }finally
        {
            fecharConexao(conexao, comando);
        }
        
        return modelo;
    }
    
    public static Modelo instanciarModelo(ResultSet rs) throws SQLException
    {
        Modelo modelo = new Modelo(
                rs.getLong("id"),
                rs.getString("nome"),
                null);
        modelo.setIdPrimariaMarca(rs.getInt("idMarca"));
        return modelo;
    }
    public static  Modelo obterModelo(int codModelo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Modelo modelo = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select * from modelo where codModelo =" + codModelo);
            rs.first();
            curso = instanciarCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return modelo;
    }
}