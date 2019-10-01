/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.NotaFiscalDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class NotaFiscal {
    private long id;
    private Date data;
    private double valor;
    private Item itens;
    private Boolean transacao;
    private int idPrimariaItem;
    private int idPrimariaTransacao;
    
    public NotaFiscal(long id, Date data, double valor, Item itens, Boolean transacao) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
    public static  List<NotaFiscal> obterNotasFiscais() throws ClassNotFoundException, SQLException {
        return NotaFiscalDAO.obterNotasFiscais();
    }
    
    public static NotaFiscal obterNotaFiscal(int codNotaFiscal) throws ClassNotFoundException, SQLException
    {
        return NotaFiscalDAO.obterNotaFiscal(codNotaFiscal);
    }
}
