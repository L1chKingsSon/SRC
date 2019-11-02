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
        <h1>Pesquisa de Carros</h1>
        <table border="1">
            <tr>
                <th>Código do Estacionamento</th>
                <th>Numero de vagas</th>
            </tr>
            <c:forEach items="${estacionamentos}" var="estacionamento">
                <tr>
                    <td><c:out value="${estacionamento.idEstacionamento}" /></td>
                    <td><c:out value="${estacionamento.numeroVagas}" /></td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
