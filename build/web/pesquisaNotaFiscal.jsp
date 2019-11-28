<%-- 
    Document   : pesquisaNotaFiscal
    Created on : 02/11/2019, 11:14:06
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Notas Fiscais</title>
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
            <h1 id="tititle">Pesquisa de Nota Fiscal</h1>
            <table border="1" id="tbl">
                <tr>
                    <th>Código da Nota</th>
                    <th>Data</th>
                    <th>Valor (em R$)</th>
                    <th>Funcionario Responsavel</th>
                    <th>CPF Cliente</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${notasFiscais}" var="notafiscal">
                    <tr>
                        <td><c:out value="${notafiscal.id}" /></td>
                        <td><c:out value="${notafiscal.data}" /></td>
                        <td><c:out value="${notafiscal.valor}" /></td>
                        <td><c:out value="${notafiscal.funcionario.nome}" /></td>
                        <td><c:out value="${notafiscal.cliente.cpf}" /></td>
                        <td><a href="ManterNotaFiscalController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${notafiscal.id}"/>">Editar</a></td>
                        <td><a href="ManterNotaFiscalController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${notafiscal.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
            <form action="ManterNotaFiscalController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
    </div>
    </body>
</html>
