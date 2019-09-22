<%-- 
    Document   : pesquisaCarro
    Created on : 20/09/2019, 14:58:44
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
        <h1>Pesquisa de Carros</h1>
        <table border="1">
            <tr>
                <th>Código do carro</th>
                <th>Placa do carro</th>
                <!--<th>Nome da marca a qual pertence</th>-->
            </tr>
            <c:forEach items="${carros}" var="carro">
                <tr>
                    <td><c:out value="${carro.id}" /></td>
                    <td><c:out value="${carro.placa}" /></td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
