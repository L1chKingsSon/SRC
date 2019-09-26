/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Endereco {
    private long id;
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private String complemento;
    
    public Endereco(long id, String cep, String uf, String cidade, String bairro, String logadouro, int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogadouro() {
        return logradouro;
    }

    public void setLogadouro(String logadouro) {
        this.logradouro = logadouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumEndereco(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException {
        return EnderecoDAO.obterEnderecos();
    }
     public static Endereco obterEndereco(int codEndereco) throws ClassNotFoundException, SQLException
    {
        return EnderecoDAO.obterEndereco(codEndereco);
    }
}
