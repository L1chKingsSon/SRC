package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static List<ContaBanco> obterContas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ContaBanco> contas = new ArrayList<ContaBanco>();
        ContaBanco contaBanco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from contabanco");
            while (rs.next()) {
                contaBanco = instanciarContaBanco(rs);
                contas.add(contaBanco);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return contas;
    }

    public static ContaBanco obterConta(int codContaBanco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ContaBanco conta = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from contabanco where id =" + codContaBanco);
            rs.first();
            conta = instanciarContaBanco(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return conta;
    }

    public static ContaBanco instanciarContaBanco(ResultSet rs) throws SQLException {
        ContaBanco contaBanco = new ContaBanco(
                rs.getInt("id"),
                rs.getString("agencia"),
                rs.getString("conta"),
                rs.getString("tipo"),
                rs.getString("nome")
        );
        return contaBanco;
    }
    
        public static void gravar(ContaBanco contaBanco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into contabanco (id, agencia, conta, tipo, nome) "
                    + "values (?,?,?,?,?,?)");
            comando.setLong(1, contaBanco.getId());
            comando.setString(2, contaBanco.getAgencia());
            comando.setString(3, contaBanco.getConta());
            comando.setString(4, contaBanco.getTipo());
            comando.setString(5, contaBanco.getNome());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(ContaBanco contaBanco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update contabanco set "
                    + "agencia = '" + contaBanco.getAgencia()+ "'"
                    + "conta = '" + contaBanco.getConta()+ "'"
                    + "tipo = '" + contaBanco.getTipo()+ "'"
                    + "nome = '" + contaBanco.getNome() + "'";
            stringSQL = stringSQL + "where id = " + contaBanco.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
        
        public static void excluir(ContaBanco contaBanco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from contabanco where id ="
                    + contaBanco.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
