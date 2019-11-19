/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.VendaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Venda {

    public static Object obterVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        private int id;
        private Carro carro;
        private int idPrimariaCarro;
        
        public Venda(int id, Carro carro)
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

    public Carro getCarro() throws ClassNotFoundException, SQLException {
        if((this.idPrimariaCarro != 0) && (this.carro == null)){
        this.carro = Carro.obterCarro(idPrimariaCarro);
        }
        return carro;
    }

    public void setCarro(Carro carro) throws ClassNotFoundException, SQLException {
        this.carro = carro;
    }

    public int getIdPrimariaCarro() throws ClassNotFoundException, SQLException {
        if((this.idPrimariaCarro != 0) && (this.carro == null))
        {
            this.carro = Carro.obterCarro(idPrimariaCarro);
        }
        return idPrimariaCarro;
    }

    public void setIdPrimariaCarro(int idPrimariaCarro) {
        this.idPrimariaCarro = idPrimariaCarro;
    }
        
    public static List<Venda> obterVendas() throws ClassNotFoundException, SQLException {
        return VendaDAO.obterVendas();
    }

    public static Venda obterVenda(int codVenda) throws ClassNotFoundException, SQLException {
        return VendaDAO.obterVenda(codVenda);
    }
    
    public void gravar() throws ClassNotFoundException, SQLException {
        VendaDAO.gravar(this);
    }
    
    public void alterar() 
            throws 
            ClassNotFoundException, 
            SQLException {
        VendaDAO.alterar(this);
    }
    
    public void excluir() 
            throws 
            ClassNotFoundException, 
            SQLException {
        VendaDAO.excluir(this);
    }        
}
