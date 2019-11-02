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
    </head>
    <body>
        <h1>Pesquisa de Nota Fiscal</h1>
        <table border="1">
            <tr>
                <th>Código da Nota</th>
                <th>Data</th>
                <th>Valor (em R$)</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${notasFiscais}" var="notafiscal">
                <tr>
                    <td><c:out value="${notafiscal.id}" /></td>
                    <td><c:out value="${notafiscal.data}" /></td>
                    <td><c:out value="${notafiscal.valor}" /></td>
                    <td><a href="ManterNotaFiscalController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${notafiscal.id}"/>">Editar</a></td>
                    <td><a href="ManterNotaFiscalController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${notafiscal.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterNotaFiscalController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
