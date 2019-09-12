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
public class Modelo {
    private long id;
    private String nome;
    private Marca marca;
    private int idPrimariaMarca;



    public Modelo(long id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

        public int getIdPrimariaMarca() {
        return idPrimariaMarca;
    }

    public void setIdPrimariaMarca(int idPrimariaMarca) {
        this.idPrimariaMarca = idPrimariaMarca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
