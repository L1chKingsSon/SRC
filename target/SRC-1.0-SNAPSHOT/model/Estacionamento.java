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
public class Estacionamento {
    @Id
    @GeneratedValue
    private int id;
    private int numeroVagas;
    @OneToOne
    private Endereco endereco;
    private int idPrimariaEndereco;

    public Estacionamento(int id, int numeroVagas, Endereco endereco) {
        this.id = id;
        this.numeroVagas = numeroVagas;
        this.endereco = endereco;
    }

    public int getIdPrimariaEndereco() {
        return idPrimariaEndereco;
    }

    public void setIdPrimariaEndereco(int idPrimariaEndereco) {
        this.idPrimariaEndereco = idPrimariaEndereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Endereco getEndereco() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaEndereco != 0) && (this.endereco == null)){
            this.endereco = Endereco.obterEndereco(idPrimariaEndereco);
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static List<Object> obterEstacionamentos() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Estacionamento.class);
    }

    public static Estacionamento obterEstacionamento(long codEstacionamento) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Estacionamento) DAO.findOne(codEstacionamento, Estacionamento.class);
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
