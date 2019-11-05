/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import model.NotaFiscal;

/**
 *
 * @author jafar
 */

public class ManterNotaFiscalController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);

        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);

        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        
        int id = Integer.parseInt(request.getParameter("txtId"));
        float valor = Float.parseFloat(request.getParameter("txtValor"));
        boolean transacao = Boolean.parseBoolean(request.getParameter("Select_transacao"));
        String data = request.getParameter("dateData");
        
        int idFuncionario = Integer.parseInt(request.getParameter("Select_funcionario"));
        int idCliente = Integer.parseInt(request.getParameter("Select_cliente"));

        try {
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            Cliente cliente = null;
            if (idCliente != 0){
                cliente = Cliente.obterCliente(idCliente);
            }
            NotaFiscal notaFiscal = new NotaFiscal(id, data, valor, transacao, funcionario, cliente);
            if (operacao.equals("Incluir")) {
                try {
                    notaFiscal.gravar();
                } catch (ClassNotFoundException e) {
                    throw new ServletException(e);
                }
            } else {
                if(operacao.equals("Editar")){
                    notaFiscal.alterar();
                } else {
                    if(operacao.equals("Excluir")){
                        notaFiscal.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaNotaFiscalController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("clientes", Cliente.obterClientes());
            if(!operacao.equals("Incluir")){
                int id = Integer.parseInt(request.getParameter("id"));
                NotaFiscal notaFiscal = NotaFiscal.obterNotaFiscal(id);
                request.setAttribute("notaFiscal", notaFiscal);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarNotaFiscal.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
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
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterNotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
