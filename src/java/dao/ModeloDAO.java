package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static List<Modelo> obterModelos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Modelo> modelos = new ArrayList<Modelo>();
        Modelo modelo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from modelo");
            while (rs.next()) {
                modelo = instanciarModelo(rs);
                modelos.add(modelo);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return modelos;
    }

    public static Modelo obterModelo(int codModelo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Modelo modelo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from modelo where id = " + codModelo);
            rs.first();
            modelo = instanciarModelo(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return modelo;
    }

    public static Modelo instanciarModelo(ResultSet rs) throws SQLException {
        Modelo modelo = new Modelo(
                rs.getLong("id"),
                rs.getString("nome"),
                null);
        modelo.setIdPrimariaMarca(rs.getInt("id_Marca"));
        return modelo;
    }

    public static void gravar(Modelo modelo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into modelo (id, nome, id_marca) "
                    + "values (?,?,?)");
            comando.setLong(1, modelo.getId());
            comando.setString(2, modelo.getNome());
            comando.setLong(3, modelo.getMarca().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void excluir(Modelo modelo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from modelo where id ="
                    + modelo.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
