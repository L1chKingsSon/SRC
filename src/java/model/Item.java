/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ItemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Item {

    private int id;
    private Carro carro;
    private NotaFiscal notaFiscal;
    private int idPrimariaNotaFiscal;
    private int idPrimariaCarro;

    public Item(int id, Carro carro, NotaFiscal notaFiscal) {
        this.id = id;
        this.carro = carro;
        this.notaFiscal = notaFiscal;
    }

    public long getId() {
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
    
    public static List<Item> obterItems() throws ClassNotFoundException, SQLException{
        return ItemDAO.obterItems();
    }
    public static Item obterItem(int codItem) throws ClassNotFoundException, SQLException{
        return ItemDAO.obterItem(codItem);
    }
    public void gravar() throws ClassNotFoundException, SQLException{
        ItemDAO.gravar(this);  
    }
    public void alterar() throws ClassNotFoundException, SQLException{
        ItemDAO.alterar(this);
    }
    public void excluir() throws ClassNotFoundException, SQLException{
        ItemDAO.excluir(this);
    }
}
