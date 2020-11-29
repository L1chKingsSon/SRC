
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
public class Marca {
    @Id
    @GeneratedValue
    private int id;
    private String nome;

    public Marca(){}

    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
    public static List<Object> obterMarcas() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Marca.class);
    }

    public static Marca obterMarca(int codMarca) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Marca) DAO.findOne(codMarca, Marca.class);
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
