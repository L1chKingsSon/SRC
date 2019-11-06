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

    private int id;
    private String placa;
    private String chassi;
    private String ano;
    private String cor;
    private Boolean IPVA;
    private String seguro;
    private String garantia;
    private double valorComprado;
    private double valorVenda;
    private Modelo modelo;
    private Estacionamento estacionamento;
    
    private int idPrimariaEstacionamento;
    private int idPrimariaModelo;

    public Carro(int id, String placa, String chassi, String ano, String cor, Boolean IPVA, String seguro, String garantia, double valorComprado, double valorVenda, Modelo modelo, Estacionamento estacionamento) {

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
        this.estacionamento = estacionamento;

    }

    public int getIdPrimariaEstacionamento() {
        return idPrimariaEstacionamento;
    }

    public void setIdPrimariaEstacionamento(int idPrimariaEstacionamento) {
        this.idPrimariaEstacionamento = idPrimariaEstacionamento;
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

    public Estacionamento getEstacionamento()
    {
        return estacionamento;
    }
    
    public void setEstacionamento(Estacionamento estacionamento)
    {
        this.estacionamento = estacionamento;
    }
    public Modelo getModelo() throws ClassNotFoundException, SQLException {
        if((modelo == null) && (idPrimariaModelo != 0))
        {
            modelo = Modelo.obterModelo(idPrimariaModelo);
        }
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
