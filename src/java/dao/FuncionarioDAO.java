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
                rs.getInt("salario"),
                rs.getString("login"),
                rs.getString("senha"),
                rs.getBoolean("nivelAcesso")
        );
        funcionario.setIdPrimariaEndereco(rs.getInt("id_endereco"));
        funcionario.setIdPrimariaContaBanco(rs.getInt("id_Conta_Banco"));
        return funcionario;
    }
    
    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where id =" + codFuncionario);
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
                    + "nome, cpf, telefone, "
                    + "id_Conta_Banco, id_Endereco, nivelAcesso) "
                    + "values (?,?,?,?,?,?,?,?,?,?)");
            comando.setLong(1, funcionario.getId());
            comando.setFloat(2, funcionario.getSalario());
            comando.setString(3, funcionario.getLogin());
            comando.setString(4, funcionario.getSenha());
            comando.setString(5, funcionario.getNome());
            comando.setString(6, funcionario.getCpf());
            comando.setString(7, funcionario.getTelefone());
            comando.setLong(8, funcionario.getContaBanco().getId());
            comando.setLong(9, funcionario.getEndereco().getId());
            comando.setBoolean(10, funcionario.getNivelAcesso());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void alterar(Funcionario funcionario) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update funcionario set "
                    + "salario = '" + funcionario.getSalario() + "', "
                    + "login = '" + funcionario.getLogin() + "', "
                    + "senha = '" + funcionario.getSenha() + "', "
                    + "nome = '" + funcionario.getNome() + "', "
                    + "CPF = '" + funcionario.getCpf() +  "', "
                    + "telefone = '" + funcionario.getTelefone() + "', ";
            if(funcionario.getContaBanco() == null)
            {
                stringSQL += "id_Conta_Banco = null, ";
            }
            else
            {
                stringSQL += "id_Conta_Banco = '" + funcionario.getContaBanco().getId() + "', ";
            }
            if(funcionario.getEndereco() == null)
            {
                stringSQL += "id_Endereco = null,";
            }
            else
            {
                stringSQL += "id_Endereco = '" + funcionario.getEndereco().getId() + "',";
            }
            
            stringSQL += " nivelAcesso = " + funcionario.getNivelAcesso();
            stringSQL += " where id = " + funcionario.getId() + ";";
            comando.execute(stringSQL);
            
        } finally
            {
                fecharConexao(conexao, comando);
            }
    }
    
    public static void excluir(Funcionario funcionario) throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    String stringSQL;
    
    try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        stringSQL = "delete from funcionario where id="
                + funcionario.getId();
        comando.execute(stringSQL);
    } finally
    {
        fecharConexao(conexao, comando);
    }
    
    }
}
