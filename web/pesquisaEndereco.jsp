<%-- 
    Document   : pesquisaEndereco
    Created on : 26/09/2019, 08:55:53
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Endereços</title>
    </head>
    <body>
        <h1>Pesquisa de Endereços</h1>
        <table border="1">
            <tr>
                <th>ID do endereço</th>
                <th>CEP</th>
                <th>UF</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Logradouro</th>
                <th>Numero</th>
                <th>Complemento</th>
            </tr>
            <c:forEach items="${enderecos}" var="endereco">
                <tr>
                    <td><c:out value="${enderecos.id}" /></td>
                    <td><c:out value="${enderecos.cep}" /></td>
                    <td><c:out value="${enderecos.uf}" /></td>
                    <td><c:out value="${enderecos.cidade}" /></td>
                    <td><c:out value="${enderecos.bairro}" /></td>
                    <td><c:out value="${enderecos.logradouro}" /></td>
                    <td><c:out value="${enderecos.numero}" /></td>
                    <td><c:out value="${enderecos.complemento}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
