/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Raphael
 */
public class Estacionamento {
    private long id;
    private long numeroVagas;
    private Endereco endereco;

    public Estacionamento(long id, long numeroVagas, Endereco endereco) {
        this.id = id;
        this.numeroVagas = numeroVagas;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
