package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

/**
 *
 * @author Raphael
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
        reserva.setIdPrimariaCliente(rs.getInt("id_Cliente"));
        reserva.setIdPrimariaModelo(rs.getInt("id_Modelo"));
        return reserva;
    }
    
    public static void gravar(Reserva reserva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into reserva (id, cor, id_Cliente, id_Modelo) "
                    + "values (?,?,?,?)");
            comando.setLong(1, reserva.getId());
            comando.setString(2, reserva.getCor());
            comando.setLong(3, reserva.getCliente().getId());
            comando.setInt(4, reserva.getModelo().getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Reserva reserva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update reserva set "
                    + "cor = '" + reserva.getCor() + "', ";
            if(reserva.getCliente() == null){
                stringSQL = stringSQL + "id_Cliente = null, ";
            } else {
                stringSQL = stringSQL + "id_Cliente = '" + reserva.getCliente().getId();
                stringSQL = stringSQL + "', ";
            }
            if(reserva.getModelo() == null)
            {
                stringSQL += "id_Modelo = null";
            }
            else{
                stringSQL += "id_Modelo = " + reserva.getModelo().getId();
            }
            stringSQL = stringSQL + " where id = " + reserva.getId() + ";";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Reserva reserva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from reserva where id ="
                    + reserva.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
