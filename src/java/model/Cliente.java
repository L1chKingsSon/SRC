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

    public Cliente(long id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco) {
        super(id, nome, cpf, telefone, endereco, contaBanco);
    }
}
