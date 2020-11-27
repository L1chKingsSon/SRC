/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAO;

import javax.persistence.*;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
@Entity
public class Reserva {
    @Id
    @GeneratedValue

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
    
    public int getIdPrimariaCliente() throws ClassNotFoundException, SQLException {
        return idPrimariaCliente;
    }

    public void setIdPrimariaCliente(int idPrimariaCliente) {
        this.idPrimariaCliente = idPrimariaCliente;
    }
    
    public int getIdPrimariaModelo() throws ClassNotFoundException, SQLException {
        return idPrimariaModelo;
    }

    public void setIdPrimariaModelo(int idPrimariaModelo) {
        this.idPrimariaModelo = idPrimariaModelo;
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

    public Modelo getModelo() throws SQLException, ClassNotFoundException {
        if((this.modelo == null) && (this.idPrimariaModelo != 0)){
            this.modelo = Modelo.obterModelo(idPrimariaModelo);
        }
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaCliente != 0) && (this.cliente == null)){
            this.cliente = Cliente.obterCliente(idPrimariaCliente);
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static List<Object> obterReservas() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Reserva.class);
    }

    public static Reserva obterReserva(long codReserva) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Reserva) DAO.findOne(codReserva, Reserva.class);
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.delete(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.update(this);
    }
}
