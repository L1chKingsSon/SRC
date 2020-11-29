/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carro;
import model.Item;
import model.NotaFiscal;

/**
 *
 * @author jafar
 */
public class ManterItemController extends HttpServlet {

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
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);

        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);

        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        
        int id = Integer.parseInt(request.getParameter("txtId"));
        int idNotaFiscal = Integer.parseInt(request.getParameter("Select_notaFiscal"));
        int idCarro = Integer.parseInt(request.getParameter("Select_carro"));

        try {
            NotaFiscal notaFiscal = null;
            if (idNotaFiscal != 0) {
                notaFiscal = NotaFiscal.obterNotaFiscal(idNotaFiscal);
            }
            Carro carro = null;
            if (idCarro != 0){
                carro = Carro.obterCarro(idCarro);
            }
            Item item = new Item(id, carro, notaFiscal);
            if (operacao.equals("Incluir")) {
                try {
                    item.gravar();
                } catch (ClassNotFoundException e) {
                    throw new ServletException(e);
                }
            } else {
                if(operacao.equals("Editar")){
                    item.alterar();
                } else {
                    if(operacao.equals("Excluir")){
                        item.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaItemController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("notasFiscais", NotaFiscal.obterNotasFiscais());
            request.setAttribute("carros", Carro.obterCarros());
            if(!operacao.equals("Incluir")){
                int id = Integer.parseInt(request.getParameter("id"));
                Item item = Item.obterItem(id);
                request.setAttribute("item", item);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarItem.jsp");
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
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
