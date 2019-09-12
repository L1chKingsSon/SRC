package dao;

import static dao.ContaBancoDAO.instanciarFuncioanrio;
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
        List<Funcioanrio> ContaBancos = new ArrayList<ContaBanco>();
        ContaBanco contaBanco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                ContaBanco = instanciarContaBanco(rs);
                ContaBancos.add(contaBanco);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }
}