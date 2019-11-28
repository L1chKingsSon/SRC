<%-- 
    Document   : cadastrarContaBanco
    Created on : 01/11/2019, 23:04:30
    Author     : Raphael
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Conta de Banco</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <nav id="sidebar" class="navbar navbar-expand-lg navbar-light bg-dark">
            <ul class="list-unstyled ">
                <ul>
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                         <a href="PesquisaMarcaController">Manter Marcas</a>
                    </li>
                    <li>
                        <a href="PesquisaModeloController">Manter Modelos</a>
                    </li>
                    <li>
                        <a href="PesquisaCarroController">Manter Carros</a>
                    </li>
                    <li>
                         <a href="PesquisaContaBancoController">Manter Contas</a>
                    </li>
                    <li>
                         <a href="PesquisaClienteController">Manter Clientes</a>
                    </li>
                    <li>
                        <a href="PesquisaEnderecoController">Manter Enderecos</a>
                    </li>
                    <li>
                       <a href="PesquisaEstacionamentoController">Manter Estacionamentos</a>
                    </li>
                    <li>
                        <a href="PesquisaFuncionarioController">Manter Funcionarios</a>
                    </li>
                    <li>
                        <a href="PesquisaReservaController">Manter Reservas</a>
                    </li>
                    <li>
                        <a href="PesquisaCompraController">Manter Compras</a>
                    </li>
                    <li>
                        <a href="PesquisaVendaController">Manter Vendas</a>
                    </li>
                    <li>
                        <a href="PesquisaNotaFiscalController">Manter Notas Fiscais</a>
                    </li>
                </ul>
            </li>
         </nav>
        <div id="corpo">
            <h1 id="tititle">
                Cadastrar Conta de Banco
            </h1>
        <form action="ManterContaBancoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterContaBanco">
            <table border="1"> 
                <tr>
                    <td>ID da Conta</td>
                    <td><input type="number" name="txtId" value="${contaBanco.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                </tr>
                <tr>
                    <td>Nome do Dono da conta</td>
                    <td><input type="text" name="txtNome" value="${contaBanco.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr>
                    <td>Agência da Conta</td>
                    <td><input type="text" name="txtAgencia" value="${contaBanco.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr>
                    <td>Número da Conta</td>
                    <td><input type="text" name="txtConta" value="${contaBanco.conta}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr>
                    <td>Tipo da Conta</td>
                    <td><input type="text" name="txtTipo" value="${contaBanco.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr >
                    <td colspan="2"><button type="submit">Confirmar</button></td>
                </tr>
            </table



        </form>
</div>

</body>
</html>