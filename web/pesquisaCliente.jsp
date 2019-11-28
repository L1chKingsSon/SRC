<%-- 
    Document   : pesquisaCliente
    Created on : 19/09/2019, 09:17:44
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
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
            <h1 id="tititle">Pesquisa de Clientes</h1>
            <table border="1" id="tbl">
                <tr>
                    <th>id do cliente</th>
                    <th>nome</th>
                    <th>CPF</th>
                    <th>Telefone</th>
                    <th>numero da conta</th>
                    <th>endereço</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td><c:out value="${cliente.id}" /></td>
                        <td><c:out value="${cliente.nome}" /></td>
                        <td><c:out value="${cliente.cpf}" /></td>
                        <td><c:out value="${cliente.telefone}" /></td>
                        <td><c:out value="${cliente.contaBanco.conta}" /></td>
                        <td><c:out value="${cliente.endereco.logradouro}, número ${cliente.endereco.numero}, ${cliente.endereco.complemento}" /></td>
                        <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${cliente.id}"/>">Editar</a></td>
                        <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
            <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
