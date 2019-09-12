package dao;

import static dao.FuncionarioDAO.instanciarFuncioanrio;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author Alisson
 */
public class FuncionarioDAO {


    public static List<Funcionario> obterFuncionario() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                Funcionario = instanciarFuncionario(rs);
                Funcionarios.add(funcionario);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }
}