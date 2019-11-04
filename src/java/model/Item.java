/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    public Carro getCarro(){
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

    public NotaFiscal getNotaFiscal() {
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
    
    
}
