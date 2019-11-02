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
    </head>
    <body>
        <h1>Pesquisa de Estacionamentos</h1>
        <table border="1">
            <tr>
                <th>Código do Estacionamento</th>
                <th>Numero de vagas</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${estacionamentos}" var="estacionamento">
                <tr>
                    <td><c:out value="${estacionamento.idEstacionamento}" /></td>
                    <td><c:out value="${estacionamento.numeroVagas}" /></td>
                    <td><a href="ManterEstacionamentoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${estacionamento.idEstacionamento}"/>">Editar</a></td>
                    <td><a href="ManterEstacionamentoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${modelo.idEstacionamento}"/>">Excluir</a></td> 
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterEstacionamentoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>           
    </body>
</html>
