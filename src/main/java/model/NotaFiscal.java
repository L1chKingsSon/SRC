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
public class NotaFiscal {
    @Id
    @GeneratedValue
    private int id;
    private String data;
    private double valor;
    private String transacao;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Cliente cliente;
    
    private int idPrimariaFuncionario;
    private int idPrimariaCliente;
    public NotaFiscal(){}

    public NotaFiscal(int id, String data, double valor, String transacao,
            Funcionario funcionario, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.transacao = transacao;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public static List<Object> obterNotasFiscais() throws ClassNotFoundException, SQLException, ClassNotFoundException, ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(NotaFiscal.class);
    }

    public static NotaFiscal obterNotaFiscal(int codNotaFiscal) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (NotaFiscal) DAO.findOne(codNotaFiscal, NotaFiscal.class);
    }

    public Funcionario getFuncionario() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaFuncionario != 0) && (this.funcionario == null)){
            this.funcionario = Funcionario.obterFuncionario(idPrimariaFuncionario);
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
