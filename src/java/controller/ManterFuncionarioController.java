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
import model.ContaBanco;
import model.Endereco;
import model.Funcionario;

/**
 *
 * @author jafar
 */
public class ManterFuncionarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);

        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException{
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);

        int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String telefone = request.getParameter("txtTelefone");
        int salario = Integer.parseInt(request.getParameter("txtSalario"));
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        Boolean nivelAcesso = request.getParameter("txtNivelAcesso") != null;
        int enderecoid = Integer.parseInt(request.getParameter("txtSelect_Endereco"));
        int contaBancoid = Integer.parseInt(request.getParameter("txtSelect_ContaBanco"));
        
        try {
            Endereco endereco = null;
            if(enderecoid != 0)
            {
                endereco = Endereco.obterEndereco(enderecoid);
            }
            ContaBanco contabanco = null;
            if(contaBancoid != 0)
            {
                contabanco = ContaBanco.obterConta(contaBancoid);
            }
            Funcionario funcionario = new Funcionario(id, nome, cpf, telefone, endereco, contabanco, salario, login, senha, nivelAcesso);
            if(operacao.equals("Incluir")){
                try{
                    funcionario.gravar();
                } catch (ClassNotFoundException e){
                    throw new ServletException(e);
                }
            } else if(operacao.equals("Editar"))
            {
                funcionario.alterar();
            } else if(operacao.equals("Excluir")){
                funcionario.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }



    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("enderecos", Endereco.obterEnderecos());
            request.setAttribute("contasBanco", ContaBanco.obterContas());
            if(!operacao.equals("Incluir")){
                int idFuncionario = Integer.parseInt(request.getParameter("id"));
                Funcionario funcionario = Funcionario.obterFuncionario(idFuncionario);
                request.setAttribute("funcionario", funcionario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
