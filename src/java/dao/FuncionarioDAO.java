package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                null,
                null,
                rs.getLong("salario"),
                rs.getString("login"),
                rs.getString("senha")
        );
        funcionario.setIdPrimariaEndereco(rs.getInt("id_endereco"));
        funcionario.setIdPrimariaContaBanco(rs.getInt("id_contaBanco"));
        return funcionario;
    }
    
    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where codFuncionario =" + codFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }
    
    public static void gravar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into funcionario (id, salario, login, senha, "
                    + "nome, CPF, telefone, "
                    + "id_Conta_Banco, id_Endereco) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            comando.setLong(1, funcionario.getId());
            comando.setFloat(2, funcionario.getSalario());
            comando.setString(3, funcionario.getLogin());
            comando.setString(4, funcionario.getSenha());
            comando.setString(5, funcionario.getNome());
            comando.setString(6, funcionario.getCpf());
            comando.setString(7, funcionario.getTelefone());
            comando.setLong(8, funcionario.getContaBanco().getId());
            comando.setLong(9, funcionario.getEndereco().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
