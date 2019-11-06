package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Estacionamento;

/**
 *
 * @author Alisson
 */
public class EstacionamentoDAO {

    public static List<Estacionamento> obterEstacionamentos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
        Estacionamento estacionamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from estacionamento");
            while (rs.next()) {
                estacionamento = instanciarEstacionamento(rs);
                estacionamentos.add(estacionamento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return estacionamentos;
    }

    /*
    public class Estacionamento {
    private long id;
    private long numeroVagas;
    private Endereco endereco;
    private int idPrimariaEndereco;
     */
    public static Estacionamento obterEstacionamento(int codEstacionamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estacionamento estacionamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estacionamento where id = " + codEstacionamento);
            rs.first();
            estacionamento = instanciarEstacionamento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return estacionamento;
    }

    public static Estacionamento instanciarEstacionamento(ResultSet rs) throws SQLException {
        Estacionamento estacionamento = new Estacionamento(
                rs.getInt("id"),
                rs.getInt("numeroVagas"),
                null
        );
        estacionamento.setIdPrimariaEndereco(rs.getInt("id_endereco"));
        return estacionamento;
    }

    public static void alterar(Estacionamento estacionamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update estacionamento set "
                    + "numeroVagas = '" + estacionamento.getNumeroVagas()+ "', ";
            if(estacionamento.getEndereco() == null){
                stringSQL += "id_endereco = null";
            } else {
                stringSQL += "id_endereco = '" + estacionamento.getEndereco().getId() + "'";
            }
            stringSQL = stringSQL + " where id = " + estacionamento.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    
        public static void excluir(Estacionamento estacionamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from estacionamento where id ="
                    + estacionamento.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        
        public static void gravar(Estacionamento estacionamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into estacionamento (id, numeroVagas, id_endereco) "
                    + "values (?,?,?)");
            comando.setInt(1, estacionamento.getId());
            comando.setInt(2, estacionamento.getNumeroVagas());
            comando.setLong(3, estacionamento.getEndereco().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
