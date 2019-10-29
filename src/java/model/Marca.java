
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

    private int id;
    private String nome;

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
    
    public static List<Marca> obterMarcas() throws ClassNotFoundException, SQLException {
        return MarcaDAO.obterMarcas();
    }

    public static Marca obterMarca(int codMarca) throws ClassNotFoundException, SQLException {
        return MarcaDAO.obterMarca(codMarca);
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        MarcaDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        MarcaDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        MarcaDAO.alterar(this);
    }
}
