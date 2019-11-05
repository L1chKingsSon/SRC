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
    private String data;
    private double valor;
    private Boolean transacao;
    private Funcionario funcionario;
    private Cliente cliente;
    
    private int idPrimariaFuncionario;
    private int idPrimariaCliente;

    public NotaFiscal(long id, String data, double valor, Boolean transacao, 
            Funcionario funcionario, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.transacao = transacao;
        this.funcionario = funcionario;
        this.cliente = cliente;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static List<NotaFiscal> obterNotasFiscais() throws ClassNotFoundException, SQLException, ClassNotFoundException, ClassNotFoundException, SQLException {
        return NotaFiscalDAO.obterNotasFiscais();
    }

    public static NotaFiscal obterNotaFiscal(int codNotaFiscal) throws ClassNotFoundException, SQLException {
        return NotaFiscalDAO.obterNotaFiscal(codNotaFiscal);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdPrimariaFuncionario() {
        return idPrimariaFuncionario;
    }

    public void setIdPrimariaFuncionario(int idPrimariaFuncionario) {
        this.idPrimariaFuncionario = idPrimariaFuncionario;
    }

    public int getIdPrimariaCliente() {
        return idPrimariaCliente;
    }

    public void setIdPrimariaCliente(int idPrimariaCliente) {
        this.idPrimariaCliente = idPrimariaCliente;
    }
    public void gravar() throws ClassNotFoundException, SQLException{
        NotaFiscalDAO.gravar(this);
    }
    public void alterar() throws ClassNotFoundException, SQLException{
        NotaFiscalDAO.alterar(this);
    }
    public void excluir() throws ClassNotFoundException, SQLException{
        NotaFiscalDAO.excluir(this);
    }
    
}
