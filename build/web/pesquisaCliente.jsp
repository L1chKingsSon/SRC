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
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>        
        <h1>Pesquisa de Clientes</h1>
        <table border="1">
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
            <input type="submit" name="btnIncluir" value="Incluir" class="button">
        </form>
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
