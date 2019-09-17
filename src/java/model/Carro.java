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
public class Carro {
    private long id;
    private Modelo modelo;
    private int idPrimariaModelo;
    private String placa;
    private String chassi;
    private String ano;
    private String cor;
    private Boolean IPVA;
    private LocalDate dataSeguro;
    private LocalDate dataGarantia;
    private double valorCompra;
    private double valorVenda;

    public Carro(long id, Modelo modelo, String placa, String chassi, String ano, String cor, Boolean IPVA, LocalDate dataSeguro, LocalDate dataGarantia, double valorCompra, double valorVenda, int idPrimariaModelo) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.ano = ano;
        this.cor = cor;
        this.IPVA = IPVA;
        this.dataSeguro = dataSeguro;
        this.dataGarantia = dataGarantia;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.idPrimariaModelo = idPrimariaModelo;
    }

    public int getIdPrimariaModelo() {
        return idPrimariaModelo;
    }

    public void setIdPrimariaModelo(int idPrimariaModelo) {
        this.idPrimariaModelo = idPrimariaModelo;
    }

    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getIPVA() {
        return IPVA;
    }

    public void setIPVA(Boolean IPVA) {
        this.IPVA = IPVA;
    }

    public LocalDate getDataSeguro() {
        return dataSeguro;
    }

    public void setDataSeguro(LocalDate dataSeguro) {
        this.dataSeguro = dataSeguro;
    }

    public LocalDate getDataGarantia() {
        return dataGarantia;
    }

    public void setDataGarantia(LocalDate dataGarantia) {
        this.dataGarantia = dataGarantia;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}