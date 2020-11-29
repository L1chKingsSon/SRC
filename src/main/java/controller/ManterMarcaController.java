/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;

/**
 *
 * @author Raphael
 */
public class ManterMarcaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if(acao.equals("confirmarOperacao"))
        {
            confirmarOperacao(request, response);
        } 
        else if (acao.equals("prepararOperacao"))
        {
            prepararOperacao(request, response);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException
    {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        
        try{
           Marca marca = new Marca(id, nome);
           if(operacao.equals("Incluir"))
           {
               try
               {
               marca.gravar();
               } catch(ClassNotFoundException e)
               {
                   throw new ServletException(e);
               }
           }
           else if(operacao.equals("Excluir"))
           {
                marca.excluir();
           }
           else if(operacao.equals("Editar"))
           {
               marca.alterar();
           }
           
           RequestDispatcher view = request.getRequestDispatcher("PesquisaMarcaController");
           view.forward(request, response);
           } catch (IOException e)
           {
               throw new ServletException(e);
           } catch(SQLException e)
           {
               throw new ServletException(e);
           }
        }
 

    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if(!operacao.equals("Incluir")){
                int idMarca = Integer.parseInt(request.getParameter("id"));
                Marca marca = Marca.obterMarca(idMarca);
                request.setAttribute("marca", marca); //nome que vai devolver para o browser
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarMarca.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMarcaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMarcaController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMarcaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMarcaController.class.getName()).log(Level.SEVERE, null, ex);
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
