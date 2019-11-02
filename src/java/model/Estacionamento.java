/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EstacionamentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Estacionamento {

    private long idEstacionamento;
    private long numeroVagas;
    private Endereco endereco;
    private int idPrimariaEndereco;

    public Estacionamento(long idEstacionamento, long numeroVagas, Endereco endereco) {
        this.idEstacionamento = idEstacionamento;
        this.numeroVagas = numeroVagas;
        this.endereco = endereco;
    }

    public int getIdPrimariaEndereco() {
        return idPrimariaEndereco;
    }

    public void setIdPrimariaEndereco(int idPrimariaEndereco) {
        this.idPrimariaEndereco = idPrimariaEndereco;
    }

    public long getIdEstacionamento() {
        return idEstacionamento;
    }

    public void setIdEstacionamento(long idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
    }

    public long getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(long numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static List<Estacionamento> obterEstacionamentos() throws ClassNotFoundException, SQLException {
        return EstacionamentoDAO.obterEstacionamentos();
    }

    public static Estacionamento obterEstacionamento(int codEstacionamento) throws ClassNotFoundException, SQLException {
        return EstacionamentoDAO.obterEstacionamento(codEstacionamento);
    }
    
}
