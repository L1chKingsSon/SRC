<%-- 
    Document   : pesquisaEstacionamento
    Created on : 02/11/2019, 03:02:04
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Estacionamentos</title>
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
            <h1 id="tititle">Pesquisa de Estacionamentos</h1>
            <table border="1" id="tbl">
                <tr>
                    <th>Código do Estacionamento</th>
                    <th>Numero de vagas</th>
                    <th>CEP</th>
                    <th>Numero</th>
                    <th>Complemento</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${estacionamentos}" var="estacionamento">
                    <tr>
                        <td><c:out value="${estacionamento.id}" /></td>
                        <td><c:out value="${estacionamento.numeroVagas}" /></td>
                        <td><c:out value="${estacionamento.endereco.cep}" /></td>
                        <td><c:out value="${estacionamento.endereco.numero}" /></td>
                        <td><c:out value="${estacionamento.endereco.complemento}" /></td>
                        <td><a href="ManterEstacionamentoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${estacionamento.id}"/>">Editar</a></td>
                        <td><a href="ManterEstacionamentoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${estacionamento.id}"/>">Excluir</a></td> 
                    </tr> 
                </c:forEach>
            </table>
            <form action="ManterEstacionamentoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>           
        </div>
    </body>
</html>
