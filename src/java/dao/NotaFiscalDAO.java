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


    public static List<NotaFiscal> obterNotaFiscal() throws ClassNotFoundException, SQLException {
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
                rs.getObject(string, type)
                
        )
    }
}