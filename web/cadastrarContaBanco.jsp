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
        <title>Cadastrar Conta de Banco</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Conta de Banco
        </h1>
    <form action="ManterContaBancoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterContaBanco">
        <table border="1"> 
            <tr>
                <td>ID da Conta</td>
                <td><input type="number" name="txtId" value="${contaBanco.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Nome do Dono da conta</td>
                <td><input type="text" name="txtNome" value="${contaBanco.nome}"></td>
            </tr>
            <tr>
                <td>Agência da Conta</td>
                <td><input type="text" name="txtAgencia" value="${contaBanco.agencia}"></td>
            </tr>
            <tr>
                <td>Número da Conta</td>
                <td><input type="text" name="txtConta" value="${contaBanco.conta}"></td>
            </tr>
            <tr>
                <td>Tipo da Conta</td>
                <td><input type="text" name="txtTipo" value="${contaBanco.tipo}"></td>
            </tr>
            <tr >
                <td colspan="2"><button type="submit">Submit</button></td>
            </tr>
        </table



    </form>

</body>
</html>