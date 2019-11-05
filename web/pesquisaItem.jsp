<%-- 
    Document   : pesquisaItem
    Created on : 04/11/2019, 21:38:11
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Itens</title>
    </head>
    <body>        
        <h1>Pesquisa de Itens</h1>
        <table border="1">
            <tr>
                <th>ID do Item</th>
                <th>ID Nota Fiscal</th>
                <th>ID Carro</th>
                <th >Ação</th>
            </tr>
            <c:forEach items="${itens}" var="item">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.idPrimariaNotaFiscal}" /></td>
                    <td><c:out value="${item.idPrimariaCarro}" /></td>
                    <td><a href="ManterItemController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${item.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterItemController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>