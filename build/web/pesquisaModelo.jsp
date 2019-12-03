<%-- 
    Document   : pesquisaModelo
    Created on : 20/09/2019, 13:23:39
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Modelos</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Pesquisa de modelos</h1>
        <table border="1">
            <tr>
                <th>Código do modelo</th>
                <th>Nome do modelo</th>
                <th>Marca</th>
                <th colspan="2">Ação</th>
                <!--<th>Nome da marca a qual pertence</th>-->
            </tr>
            <c:forEach items="${modelos}" var="modelo">
                <tr>
                    <td><c:out value="${modelo.id}" /></td>
                    <td><c:out value="${modelo.nome}" /></td>
                    <td><c:out value="${modelo.marca.nome}" /></td>
                    <td><a href="ManterModeloController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${modelo.id}"/>">Editar</a></td>
                    <td><a href="ManterModeloController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${modelo.id}"/>">Excluir</a></td>                    
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterModeloController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="button">
        </form>
        <a href="index.jsp" class="homelink">home</a>        
    </body>
</html>
