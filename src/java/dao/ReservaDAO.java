package dao;

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

    public static List<Reserva> obterReservas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Reserva> reservas = new ArrayList<Reserva>();
        Reserva reserva = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from reserva");
            while (rs.next()) {
                reserva = instanciarReserva(rs);
                reservas.add(reserva);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return reservas;
    }

    public static Reserva obterReserva(int codReserva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Reserva reserva = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from reserva where id = " + codReserva);
            rs.first();
            reserva = instanciarReserva(rs);
        } finally {
            fecharConexao(conexao, comando);
        }

        return reserva;
    }

    public static Reserva instanciarReserva(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva(
                rs.getInt("id"),
                rs.getString("cor"),
                null,
                null
        );
        return reserva;
    }
}
