<%-- 
    Document   : pesquisaContaBanco
    Created on : 21/09/2019, 13:13:02
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Contas de Banco</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Pesquisa de Contas de Banco</h1>
        <table border="1">
            <tr>
                <th>id da conta</th>
                <th>agência da conta</th>
                <th>numero da conta</th>
                <th>nome do dono</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${contas}" var="contabanco">
                <tr>
                    <td><c:out value="${contabanco.id}" /></td>
                    <td><c:out value="${contabanco.agencia}" /></td>
                    <td><c:out value="${contabanco.conta}" /></td>
                    <td><c:out value="${contabanco.nome}" /></td>
                    <td><a href="ManterContaBancoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${contabanco.id}"/>">Editar</a></td>
                    <td><a href="ManterContaBancoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${contabanco.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterContaBancoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="button">
        </form>
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
