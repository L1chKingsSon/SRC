package dao;

import static dao.ReservaDAO.instanciarFuncioanrio;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

/**
 *
 * @author Alisson
 */
public class ReservaDAO {


    public static List<Reserva> obterReserva() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Reserva> reserva = new ArrayList<Reserva>();
        Reserva reserva = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from carro");
            while(rs.next())
            {
                reserva = instanciarReserva(rs);
                reserva.add(reserva);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }
}