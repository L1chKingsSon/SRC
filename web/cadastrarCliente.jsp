<%-- 
    Document   : cadastrarContaBanco
    Created on : 01/11/2019, 23:04:30
    Author     : Raphael
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Conta de Banco
        </h1>
    <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCliente">
        <table border="1"> 
            <tr>
                <td>ID Cliente</td>
                <td><input type="number" name="txtId" value="${cliente.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Nome</td>
                <td><input type="text" name="txtNome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>CPF</td>
                <td><input name="txtCpf" type="number" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Telefone</td>
                <td><input type="text" name="txtTelefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Conta do Banco</td>
                <td>
                    <select name="txtSelect_conta" id="contaBanco" <c:if test="${operacao == 'Excluir'}"> disabled </c:if> >
                            <option value="0" <c:if test="${cliente.contaBanco.id == null}"> selected</c:if></option>
                            <c:forEach items="${contaBancos}" var="contaBanco">
                                <option value="${contaBanco.id}" <c:if test="${cliente.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>${contaBanco.conta}</option>
                            </c:forEach>
                        </select>
                </td>
            </tr>
            <tr>
                <td>Endereco</td>
                <td>
                    <select name="txtSelect_endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> disabled </c:if> >
                            <option value="0" <c:if test="${cliente.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${cliente.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}</option>
                            </c:forEach>
                        </select>
                    
                </td>
            </tr>
            <tr >
                <td colspan="2"><button type="submit">Submit</button></td>
            </tr>
        </table



    </form>

</body>
</html>