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
public class Item {
    @Id
    @GeneratedValue

    private int id;
    @ManyToOne
    private Carro carro;
    @ManyToOne
    private NotaFiscal notaFiscal;
    private int idPrimariaNotaFiscal;
    private int idPrimariaCarro;

    public Item(){}

    public Item(int id, Carro carro, NotaFiscal notaFiscal) {
        this.id = id;
        this.carro = carro;
        this.notaFiscal = notaFiscal;
    }

    public int getId() {
        return id;
    }
    
    public Carro getCarro() throws SQLException, ClassNotFoundException{
        if((this.idPrimariaCarro != 0) && (this.carro == null)){
            this.carro = Carro.obterCarro(idPrimariaCarro);
        }
        return carro;
    }
    
    public void setCarro(Carro carro){
        this.carro = carro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrimariaNotaFiscal() {
        return idPrimariaNotaFiscal;
    }

    public void setIdPrimariaNotaFiscal(int idPrimariaNotaFiscal) {
        this.idPrimariaNotaFiscal = idPrimariaNotaFiscal;
    }

    public NotaFiscal getNotaFiscal() throws SQLException, ClassNotFoundException{
        if((this.idPrimariaNotaFiscal != 0) && (this.notaFiscal == null)){
            this.notaFiscal = NotaFiscal.obterNotaFiscal(idPrimariaNotaFiscal);
        }
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getIdPrimariaCarro() {
        return idPrimariaCarro;
    }

    public void setIdPrimariaCarro(int idPrimariaCarro) {
        this.idPrimariaCarro = idPrimariaCarro;
    }
    
    public static List<Object> obterItems() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        return DAO.findAll(Item.class);
    }
    public static Item obterItem(int codItem) throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        return (Item) DAO.findOne(codItem, Item.class);
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
