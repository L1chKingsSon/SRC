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
    private float IPVA;
    private String seguro;
    private String garantia;
    private double valorComprado;
    private double valorVenda;
    private Modelo modelo;
    private int idPrimariaModelo;

    public Carro(long id, String placa, String chassi, String ano, String cor, float IPVA,
            String seguro, String garantia, double valorComprado, double valorVenda, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.ano = ano;
        this.cor = cor;
        this.IPVA = IPVA;
        this.seguro = seguro;
        this.garantia = garantia;
        this.valorComprado = valorComprado;
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

    public float getIPVA() {
        return IPVA;
    }

    public void setIPVA(float IPVA) {
        this.IPVA = IPVA;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public double getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(double valorComprado) {
        this.valorComprado = valorComprado;
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
    
    public void gravar() throws ClassNotFoundException, SQLException {
        CarroDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        CarroDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        CarroDAO.alterar(this);
    }
    
}
