/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ContaBanco;
import model.Endereco;

/**
 *
 * @author jafar
 */
public class ManterClienteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, ClassNotFoundException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("enderecos", Endereco.obterEnderecos());
            request.setAttribute("contaBancos", ContaBanco.obterContas());
            if(!operacao.equals("Incluir")){
                int id = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = Cliente.obterCliente(id);
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCliente.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);

        int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String telefone = request.getParameter("txtTelefone");
        int enderecoid = Integer.parseInt(request.getParameter("txtSelect_endereco"));
        int contaBancoid = Integer.parseInt(request.getParameter("txtSelect_conta"));

        try {
            Endereco endereco = null;
            if (enderecoid != 0) {
                endereco = Endereco.obterEndereco(enderecoid);
            }
            ContaBanco contabanco = null;
            if (contaBancoid != 0) {
                contabanco = ContaBanco.obterConta(contaBancoid);
            }
            Cliente cliente = new Cliente(id, nome, cpf, telefone, endereco, contabanco);
            if (operacao.equals("Incluir")) {
                try {
                    cliente.gravar();
                } catch (ClassNotFoundException e) {
                    throw new ServletException(e);
                }
            } else {
                if (operacao.equals("Editar")) {
                    cliente.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        cliente.excluir();
                    }
                }
            }
                RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
                view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

// </editor-fold>

