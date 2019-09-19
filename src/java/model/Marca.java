/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MarcaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Marca {
    private long id;
    private String nome;

    public Marca(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
//    public void gravar() throws SQLException, ClassNotFoundException
//    {
//        MarcaDAO.gravar(this);
//    }
    
    public static  List<Marca> obterMarcas() throws ClassNotFoundException, SQLException {
        return MarcaDAO.obterMarcas();
        
    }
}
