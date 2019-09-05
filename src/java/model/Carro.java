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
public class Carro {
    private String placa;
    private String modelo;
    private String chassi;
    private String ano;
    private String marca;
    private String cor;
    private String ipva;
    private String seguro;
    private float valorComprado;
    private int idCarro;
    private Estacionamento Estacionamento;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIpva() {
        return ipva;
    }

    public void setIpva(String ipva) {
        this.ipva = ipva;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public float getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(float valorComprado) {
        this.valorComprado = valorComprado;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public Estacionamento getEstacionamento() {
        return Estacionamento;
    }

    public void setEstacionamento(Estacionamento Estacionamento) {
        this.Estacionamento = Estacionamento;
    }
}