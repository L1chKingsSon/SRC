<%-- 
    Document   : cadastrarItem
    Created on : 04/11/2019, 21:27:27
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Item</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Item
        </h1>
        <form action="ManterItemController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterItem">
            <table border="1">
                <tr>
                    <td>ID do Item</td>
                    <td>
                        <input type="number" name="txtId" value="${item.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </td>
                </tr>
                <tr>
                    <td>
                        ID Nota Fiscal
                    </td>
                    <td><select name="Select_notaFiscal" id="notaFiscal" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${item.notaFiscal.id == null}"> selected</c:if></option>
                            <c:forEach items="${notasFiscais}" var="notaFiscal">
                                <option value="${notaFiscal.id}" <c:if test="${item.idPrimariaNotaFiscal == notaFiscal.id}"> selected</c:if>>${notaFiscal.id}</option>
                            </c:forEach>
                        </select>
                    <td>
                </tr>
                <tr>
                    <td>
                        Placa Carro
                    </td>
                    <td><select name="Select_carro" id="carro" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${item.carro.id == null}"> selected</c:if></option>
                            <c:forEach items="${carros}" var="carro">
                                <option value="${carro.id}" <c:if test="${item.idPrimariaCarro == carro.id}"> selected</c:if>>${carro.placa}</option>
                            </c:forEach>
                        </select>
                    <td>
                </tr>

                <button type="submit" >Confirmar</button>
        </form>
    </table>
     <a href="index.jsp">home</a>
    </body>
</html>
