package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ContaBanco;

/**
 *
 * @author Alisson
 */
public class ContaBancoDAO {


    public static List<ContaBanco> obterContaBanco() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ContaBanco> contaBancos = new ArrayList<ContaBanco>();
        ContaBanco contaBanco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                contaBanco = instanciarContaBanco(rs);
                contaBancos.add(contaBanco);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return contaBancos;
    }
    
    public static ContaBanco obterEndereco(int codContaBanco) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        ContaBanco contaBanco = null;
        try
        {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ContaBanco where idContaBanco = "+ codContaBanco);
            rs.first();
            contaBanco = instanciarContaBanco(rs);
        }finally
        {
            fecharConexao(conexao, comando);
        }
        
        return contaBanco;
    }
    
    public static ContaBanco instanciarContaBanco(ResultSet rs) throws SQLException
    {
        ContaBanco contaBanco = new ContaBanco
                (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("agencia"),
                        rs.getString("conta"),
                        rs.getString("tipo")
                );
        return contaBanco;
    }
}