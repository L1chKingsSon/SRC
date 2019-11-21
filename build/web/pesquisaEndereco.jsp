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
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${enderecos}" var="endereco">
                <tr>
                    <td><c:out value="${endereco.id}" /></td>
                    <td><c:out value="${endereco.cep}" /></td>
                    <td><c:out value="${endereco.uf}" /></td>
                    <td><c:out value="${endereco.cidade}" /></td>
                    <td><c:out value="${endereco.bairro}" /></td>
                    <td><c:out value="${endereco.logradouro}" /></td>
                    <td><c:out value="${endereco.numero}" /></td>
                    <td><c:out value="${endereco.complemento}" /></td>
                    <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${endereco.id}"/>">Editar</a></td>
                    <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${endereco.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
         <form action="ManterEnderecoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <a href="index.jsp">home</a>
    </body>
</html>
