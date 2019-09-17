package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
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

public static NotaFiscal obterNotaFiscal(int id) throws ClassNotFoundException, SQLException
    {
        Connection conexao = null;
        Statement comando = null;
        NotaFiscal notafiscal = null;
        try
        {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from reserva where idinteresse = "+ id);
            rs.first();
            notafiscal = instanciarNotaFiscal(rs);
        }finally
        {
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
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                notaFiscal = instanciarNotaFiscal(rs);
                notasFiscais.add(notaFiscal);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return notasFiscais;
    }
    
    public static NotaFiscal instanciarNotaFiscal(ResultSet rs) throws SQLException
    {
        NotaFiscal notaFiscal = new NotaFiscal(rs.getInt("id"), 
                rs.getDate("data"), 
                rs.getDouble("valor"),
                null,
                null);
            notaFiscal.setIdPrimariaItem(rs.getInt("idItem");
            notaFiscal.setIdPrimariaTransacao("idTransacao");
            return notaFiscal;
    }
}