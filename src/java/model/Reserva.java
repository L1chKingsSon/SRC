/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ReservaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Reserva {

    private long id;
    private String cor;
    private Modelo modelo;
    private Cliente cliente;
    private int idPrimariaModelo;
    private int idPrimariaCliente;

    public Reserva(long id, String cor, Modelo modelo, Cliente cliente) {
        this.id = id;
        this.cor = cor;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static List<Reserva> obterReservas() throws ClassNotFoundException, SQLException {
        return ReservaDAO.obterReservas();
    }

    public static Reserva obterReserva(int codReserva) throws ClassNotFoundException, SQLException {
        return ReservaDAO.obterReserva(codReserva);
    }
}
