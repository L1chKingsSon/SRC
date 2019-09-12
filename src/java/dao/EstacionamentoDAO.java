package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
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


    public static List<Estacionamento> obterEstacionamento() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
        Estacionamento estacionamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                estacionamento = instanciarEstacionamento(rs);
                estacionamentos.add(estacionamento);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return estacionamentos;
    }
    
    public static Estacionamento instanciarEstacionamento(ResultSet rs) throws SQLException
    {
        Estacionamento estacionamento = new Estacionamento
                (
                        rs.getInt("id"),
                        rs.getInt("numeroVagas"),
                        null
                );
        estacionamento.setIdPrimariaEndereco(rs.getInt("idEndereco"));
        return estacionamento;
    }
}