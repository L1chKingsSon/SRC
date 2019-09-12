package dao;

import static dao.NotaFiscalDAO.instanciarFuncioanrio;
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
        List<NotaFiscal> notaFiscais = new ArrayList<NotaFiscal>();
        NotaFiscal notaFiscal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                notaFiscal = instanciarNotaFiscal(rs);
                notaFiscais.add(notaFiscal);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }
}