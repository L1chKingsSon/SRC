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

    public Cliente(long id, String nome, String cpf, String telefone, Endereco endereco, ContaBanco contaBanco, int idPrimariaEndereco, int idPrimariaContaBanco) {
        super(id, nome, cpf, telefone, endereco, contaBanco, idPrimariaEndereco, idPrimariaContaBanco);
    }
    public static  Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select * from cliente where codCliente =" + codCliente);
            rs.first();
            curso = instanciarCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
    }
}
