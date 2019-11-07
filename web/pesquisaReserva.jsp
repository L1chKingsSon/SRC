<%-- 
    Document   : pesquisaReserva
    Created on : 02/11/2019, 10:58:40
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Reservas</title>
    </head>
    <body>
        <h1>Pesquisa de Reserva</h1>
        <table border="1">
            <tr>
                <th>Código da Reserva</th>
                <th>Cor do carro</th>
                <th>Modelo</th>
                <th>CPF cliente</th>
                <th colspan="2">Ação</th>
                <!--<th>Nome da marca a qual pertence</th>-->
            </tr>
            <c:forEach items="${reservas}" var="reserva">
                <tr>
                    <td><c:out value="${reserva.id}" /></td>
                    <td><c:out value="${reserva.cor}" /></td>
                    <td><c:out value="${reserva.modelo.nome}" /> </td>
                    <td><c:out value="${reserva.cliente.cpf}" /> </td>
                    <td><a href="ManterReservaController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${reserva.id}"/>">Editar</a></td>
                    <td><a href="ManterReservaController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${reserva.id}"/>">Excluir</a></td>                    
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterReservaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form> 
        <a href="index.jsp">home</a>
    </body>
</html>
