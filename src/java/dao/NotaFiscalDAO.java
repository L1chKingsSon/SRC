package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.NotaFiscal;

/**
 *
 * @author Alisson
 */
public class NotaFiscalDAO {

    public static NotaFiscal obterNotaFiscal(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        NotaFiscal notafiscal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from notafiscal where id = " + id);
            rs.first();
            notafiscal = instanciarNotaFiscal(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return notafiscal;
    }

    public static List<NotaFiscal> obterNotasFiscais() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();
        NotaFiscal notaFiscal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from notafiscal");
            while (rs.next()) {
                notaFiscal = instanciarNotaFiscal(rs);
                notasFiscais.add(notaFiscal);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return notasFiscais;
    }

    public static NotaFiscal instanciarNotaFiscal(ResultSet rs) throws SQLException {
        NotaFiscal notaFiscal = new NotaFiscal(
                rs.getInt("id"),
                rs.getString("data"),
                rs.getDouble("valor"),
                rs.getString("transacao"),
                null,
                null);
        notaFiscal.setIdPrimariaFuncionario(rs.getInt("id_Funcionario"));
        notaFiscal.setIdPrimariaCliente(rs.getInt("id_Cliente"));
        return notaFiscal;
    }
    
    public static void gravar(NotaFiscal notaFiscal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into notafiscal (id, data, valor, Transacao, id_Funcionario, id_Cliente) "
                    + "values (?,?,?,?,?,?)");
            comando.setLong(1, notaFiscal.getId());
            comando.setString(2, notaFiscal.getData());
            comando.setDouble(3, notaFiscal.getValor());
            comando.setString(4, notaFiscal.getTransacao());
            comando.setLong(5, notaFiscal.getFuncionario().getId());
            comando.setLong(6, notaFiscal.getCliente().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void alterar(NotaFiscal notaFiscal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update notafiscal set data= '"+ notaFiscal.getData() +"', "
                    + "valor= '"+ notaFiscal.getValor() +"', "
                    + "Transacao= '"+ notaFiscal.getTransacao() +"' , ";
            if(notaFiscal.getFuncionario() == null){
                stringSQL += "id_Funcionario = null" + ", ";
            } else {
                stringSQL += "id_Funcionario = '" + notaFiscal.getFuncionario().getId() + "' , ";
            }
            if(notaFiscal.getCliente() == null){
                stringSQL += "id_Cliente = null'" + "' ";
            } else {
                stringSQL += "id_Cliente = '" + notaFiscal.getCliente().getId() + "' ";
            }
            stringSQL += "where id = '" + notaFiscal.getId() + "';";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void excluir(NotaFiscal notaFiscal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from notafiscal where id ="
                    + notaFiscal.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
