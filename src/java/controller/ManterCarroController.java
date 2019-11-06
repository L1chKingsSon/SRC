/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carro;
import model.Estacionamento;
import model.Modelo;

/**
 *
 * @author jafar
 */
public class ManterCarroController extends HttpServlet {

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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);

        int id = Integer.parseInt(request.getParameter("txtId"));
        String cor = request.getParameter("txtCor");
        String placa = request.getParameter("txtPlaca");
        String chassi = request.getParameter("txtChassi");
        String ano = request.getParameter("txtAno");
        Boolean IPVA = request.getParameter("txtIpva") != null;
        String seguro = request.getParameter("txtSeguro");
        String garantia = request.getParameter("txtGarantia");
        double valorComprado = Double.parseDouble(request.getParameter("txtValorComprado"));
        double valorVenda = Double.parseDouble(request.getParameter("txtValorVenda"));

        int IdModelo = Integer.parseInt(request.getParameter("txtSelect_Modelo"));
        int IdEstacionamento = Integer.parseInt(request.getParameter("txtSelect_Estacionamento"));

        try {
            Modelo modelo = null;
            if (IdModelo != 0) {
                modelo = Modelo.obterModelo(IdModelo);
            }
            Estacionamento estacionamento = null;
            if (IdEstacionamento != 0) {
                estacionamento = Estacionamento.obterEstacionamento(IdEstacionamento);
            }

            Carro carro = new Carro(id, placa, chassi, ano, cor, IPVA, seguro, ano, valorComprado, valorVenda, modelo, estacionamento);
            if (operacao.equals("Incluir")) {
                try {
                    carro.gravar();
                } catch (ClassNotFoundException e) {
                    throw new ServletException(e);
                }
            } else {
                if (operacao.equals("Editar")) {
                    carro.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        carro.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCarroController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("modelos", Modelo.obterModelos());
            //request.setAttribute("estacionamentos", Estacionamento.obterEstacionamentos());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Carro carro = Carro.obterCarro(id);
                request.setAttribute("carro", carro);

            }   
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCarro.jsp");
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
            Logger.getLogger(ManterCarroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCarroController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterCarroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCarroController.class.getName()).log(Level.SEVERE, null, ex);
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
