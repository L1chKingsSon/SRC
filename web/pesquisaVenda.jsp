<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Vendas</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Pesquisa de Vendas</h1>
        <table border="1">
            <tr>
                <th>Código da Venda</th>
                <th>Modelo Carro</th>
                <th>Cor Carro</th>
                <th>Placa Carro</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${vendas}" var="venda">
                <tr>
                    <td><c:out value="${venda.id}" /></td>
                    <td><c:out value="${venda.carro.modelo}" /></td>
                    <td><c:out value="${venda.carro.cor}" /></td>
                    <td><c:out value="${venda.carro.placa}" /></td>
                    <td><a href="ManterVendaController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${venda.id}"/>">Editar</a></td>
                    <td><a href="ManterVendaController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${venda.id}"/>">Excluir</a></td> 
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="button">
        </form>           
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
