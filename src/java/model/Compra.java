/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CompraDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Compra {
        private int id;
        private Carro carro;
        private int idPrimariaCarro;
        
        public Compra(int id, Carro carro)
        {
            this.id = id;
            this.carro = carro;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getIdPrimariaCarro() {
        return idPrimariaCarro;
    }

    public void setIdPrimariaCarro(int idPrimariaCarro) {
        this.idPrimariaCarro = idPrimariaCarro;
    }
        
    public static List<Compra> obterCompras() throws ClassNotFoundException, SQLException {
        return CompraDAO.obterCompras();
    }

    public static Compra obterCompra(int codCompra) throws ClassNotFoundException, SQLException {
        return CompraDAO.obterCompra(codCompra);
    }
    
    public void gravar() throws ClassNotFoundException, SQLException {
        CompraDAO.gravar(this);
    }
    
    public void alterar() 
            throws 
            ClassNotFoundException, 
            SQLException {
        CompraDAO.alterar(this);
    }
    
    public void excluir() 
            throws 
            ClassNotFoundException, 
            SQLException {
        CompraDAO.excluir(this);
    }        
}
