/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import model.Cliente;

/**
 *
 * @author jafar
 */
public class ClienteDAO {
    
    public static List<Cliente> obterClientes()
    Connection conexao = null;
    Statement comando = null;
    List<Cliente> clientes = new ArrayList<Cliente>();
    Cliente cliente = null;
    
    try
    {
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery ("select * from cliente");
        while(rs.next())
        {
            cliente = instanciarCliente(rs);
            clientes.add(cliente);
        }finally
        {
                fecharConexao(conexao,comando);
                }
    }
    
    public static Cliente instanciarCliente(ResultSet rs)
}
