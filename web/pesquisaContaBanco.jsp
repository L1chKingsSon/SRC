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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisa de Contas de Banco</h1>
        <table border="1">
            <tr>
                <th>id da conta</th>
                <th>agência da conta</th>
            </tr>
            <c:forEach items="${contas}" var="contabanco">
                <tr>
                    <td><c:out value="${contabanco.id}" /></td>
                    <td><c:out value="${contabanco.agencia}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
