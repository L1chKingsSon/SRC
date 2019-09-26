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
public class Cliente extends Pessoa{

    public Cliente(int id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, int idPrimariaEndereco, int idPrimariaContaBanco) {
        super(id, nome, cpf, telefone, endereco, contaBanco, idPrimariaEndereco, idPrimariaContaBanco);
    }

    public void setIDPrimariaContaBanco(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
