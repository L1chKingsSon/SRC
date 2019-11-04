<%-- 
    Document   : PesquisaFuncionario
    Created on : 02/11/2019, 03:50:05
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionarios</title>
    </head>
    <body>
    <body>        
        <h1>Pesquisa de Funcionarios</h1>
        <table border="1">
            <tr>
                <th>id do funcionario</th>
                <th>nome</th>
                <th>CPF</th>
                <th>telefone</th>
                <th>salario</th>
                <th>login</th>
                <th>senha</th>
                <th>NivelAcesso</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.id}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.cpf}" /></td>
                    <td><c:out value="${funcionario.telefone}" /></td>
                    <td><c:out value="${funcionario.salario}" /></td>
                    <td><c:out value="${funcionario.login}" /></td>
                    <td><c:out value="${funcionario.senha}" /></td>
                    <td><c:out value="${funcionario.nivelAcesso}" /></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${funcionario.id}"/>">Editar</a></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${funcionario.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
