
<%-- 
    Document   : newjsp
    Created on : 11/09/2019, 18:52:59
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Reserva</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Reserva
        </h1>
        <form action="ManterReservaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterReserva">
            <table border="1">
                <tr>
                    <td>ID da reserva</td>
                    <td>
                <input type="number" name="txtId" value="${reserva.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                </td>
                </tr>
                <tr>
                    <td>cor da reserva</td>
                    <td><input type="text" name="txtCor" value="${reserva.cor}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr>
                    <td>
                        Modelo da reserva
                    </td>
                    <td><select name="txtSelect_Modelo" id="modelo" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${reserva.modelo.id == null}"> selected</c:if></option>
                            <c:forEach items="${modelos}" var="modelo">
                                <option value="${modelo.id}" <c:if test="${reserva.idPrimariaModelo == modelo.id}"> selected</c:if>>${modelo.nome}</option>
                            </c:forEach>
                        </select>
                </tr>
                <tr>
                    <td>
                        Cliente
                    </td>
                    <td>
                        <select name="txtSelect_Cliente" id="cliente" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${reserva.cliente.id == null}"> selected</c:if></option>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${reserva.idPrimariaCliente == cliente.id}"> selected</c:if>>${cliente.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                

                <button type="submit" >Cadastrar</button>
        </form>
    </table>
    </form>
<a href="index.jsp">home</a>
</body>
</html>