package dao;

import static dao.MarcaDAO.instanciarFuncioanrio;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Marca;

/**
 *
 * @author Alisson
 */
public class MarcaDAO {


    public static List<Marca> obterMarca() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Marca> Marcas = new ArrayList<Marca>();
        Marca marca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                Marca = instanciarMarca(rs);
                Marca.add(marca);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }
}