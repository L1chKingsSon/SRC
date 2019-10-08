/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CarroDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Carro {

    private long id;
    private String placa;
    private String chassi;
    private String ano;
    private String cor;
    private Boolean IPVA;
    private Date seguro;
    private Date garantia;
    private double valorComprado;
    private double valorVenda;
    private Modelo modelo;
    private int idPrimariaModelo;

    public Carro(long id, String placa, String chassi, String ano, String cor, Boolean IPVA, Date dataSeguro, Date dataGarantia, double valorCompra, double valorVenda, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.ano = ano;
        this.cor = cor;
        this.IPVA = IPVA;
        this.seguro = dataSeguro;
        this.garantia = dataGarantia;
        this.valorComprado = valorCompra;
        this.valorVenda = valorVenda;
        this.modelo = modelo;
    }

    public int getIdPrimariaModelo() throws ClassNotFoundException, SQLException {
        if ((this.idPrimariaModelo != 0) && (this.modelo == null)) {
            this.modelo = Modelo.obterModelo(this.idPrimariaModelo);
        }
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

    public Date getDataSeguro() {
        return seguro;
    }

    public void setDataSeguro(Date dataSeguro) {
        this.seguro = dataSeguro;
    }

    public Date getDataGarantia() {
        return garantia;
    }

    public void setDataGarantia(Date dataGarantia) {
        this.garantia = dataGarantia;
    }

    public double getValorCompra() {
        return valorComprado;
    }

    public void setValorCompra(double valorCompra) {
        this.valorComprado = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public static List<Carro> obterCarros() throws ClassNotFoundException, SQLException {
        return CarroDAO.obterCarros();
    }

    public static Carro obterCarro(int codCarro) throws ClassNotFoundException, SQLException {
        return CarroDAO.obterCarro(codCarro);
    }
}
