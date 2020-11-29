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
public class Modelo {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @ManyToOne
    private Marca marca;
    private int idPrimariaMarca;

    public Modelo(){}

    public Modelo(int id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public int getIdPrimariaMarca() throws ClassNotFoundException, SQLException {
        if ((this.idPrimariaMarca != 0) && (this.marca == null)) {
            this.marca = Marca.obterMarca(this.idPrimariaMarca);
        }
        return idPrimariaMarca;
    }

    public void setIdPrimariaMarca(int idPrimariaMarca) {
        this.idPrimariaMarca = idPrimariaMarca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaMarca != 0) && (this.marca == null)){
            this.marca = Marca.obterMarca(idPrimariaMarca);
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public static List<Object> obterModelos() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Modelo.class);
    }

    public static Modelo obterModelo(int codModelo) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Modelo) DAO.findOne(codModelo, Modelo.class);
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
