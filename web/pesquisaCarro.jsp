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
        <title>Listar Carros</title>
    </head>
    <body>
        <h1>Pesquisa de Carros</h1>
        <table border="1">
            <tr>
                <th>ID do carro</th>
                <th>Cor</th>
                <th>Placa do carro</th>
                <th>Chassi</th>
                <th>Ano</th>
                <th>IPVA</th>
                <th>Data Seguro</th>
                <th>Data Garantia</th>
                <th>Valor Comprado</th>
                <th>Nome do Modelo</th>
                <th>ID do estacionamento</th>
                <th>Valor de Venda</th>
                <th colspan="2">Ação</th>
                <!--<th>Nome da marca a qual pertence</th>-->
            </tr>
            <c:forEach items="${carros}" var="carro">
                <tr>
                    <td><c:out value="${carro.id}" /></td>
                    <td><c:out value="${carro.cor}" /></td>
                    <td><c:out value="${carro.placa}" /></td>
                    <td><c:out value="${carro.chassi}" /></td>
                    <td><c:out value="${carro.ano}" /></td>
                    <td><c:out value="${carro.IPVA}" /></td>
                    <td><c:out value="${carro.seguro}" /></td>
                    <td><c:out value="${carro.garantia}" /></td>
                    <td><c:out value="${carro.valorComprado}" /></td>
                    <td><c:out value="${carro.modelo.nome}" /></td> 
                    <td><c:out value="${carro.idPrimariaEstacionamento}" /></td>
                    <td><c:out value="${carro.valorVenda}" /></td>
                    <td><a href="ManterCarroController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${carro.id}"/>">Editar</a></td>
                    <td><a href="ManterCarroController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${carro.id}"/>">Excluir</a></td> 
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterCarroController?acao=prepararOperacao&operacao=Incluir" method="post">
         <button type="submit">Submit</button></td>
        </form>
    </body>
</html>
