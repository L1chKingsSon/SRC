/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Raphael
 */
public class NotaFiscal {
    private long id;
    private LocalDate data;
    private double valor;
    private Item itens;
    private Boolean transacao;
    private int idPrimariaItem;
    private int idPrimariaTransacao;
    
    public NotaFiscal(long id, LocalDate data, double valor, Item itens, Boolean transacao) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.itens = itens;
        this.transacao = transacao;
    }
    
    public void setIdPrimariaTransacao(int x)
    {
        this.idPrimariaTransacao = x;
    }
    
    public void setIdPrimariaItem(int x)
    {
        this.idPrimariaItem = x;
    }

    public Boolean getTransacao() {
        return transacao;
    }

    public void setTransacao(Boolean transacao) {
        this.transacao = transacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Item getItens() {
        return itens;
    }

    public void setItens(Item itens) {
        this.itens = itens;
    }
}
