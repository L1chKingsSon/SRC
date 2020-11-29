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
 * @author Raphael
 */
@Entity
public class Venda {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Carro carro;

    private int idPrimariaCarro;

    public Venda(){}

    public Venda(int id, Carro carro) {
        this.id = id;
        this.carro = carro;
    }

    public static Object obterVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carro getCarro() throws ClassNotFoundException, SQLException {
        if ((this.idPrimariaCarro != 0) && (this.carro == null)) {
            this.carro = Carro.obterCarro(idPrimariaCarro);
        }
        return carro;
    }

    public void setCarro(Carro carro) throws ClassNotFoundException, SQLException {
        this.carro = carro;
    }

    public int getIdPrimariaCarro() throws ClassNotFoundException, SQLException {
        if ((this.idPrimariaCarro != 0) && (this.carro == null)) {
            this.carro = Carro.obterCarro(idPrimariaCarro);
        }
        return idPrimariaCarro;
    }

    public void setIdPrimariaCarro(int idPrimariaCarro) {
        this.idPrimariaCarro = idPrimariaCarro;
    }

    public static List<Object> obterVendas() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Venda.class);
    }

    public static Venda obterVenda(int codVenda) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Venda) DAO.findOne(codVenda, Venda.class);
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.delete(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.update(this);
    }
}
