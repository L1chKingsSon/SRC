
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Modelo e/ou Marca</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Modelo e/ou Marca
        </h1>
        <form action="ManterModeloController?acao=confirmarOperacao&Operacao&operacao=${operacao}" method="post" name="frmManterModelo">
            <table border="1">
                <tr>
                    <td>ID do Modelo</td>
                    <td>
                <input type="number" name="idmodelo" value="${modelo.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </td>
                </tr>
                <tr>
                    <td>Nome do Modelo</td>
                    <td><input type="text" name="modelo" value="${modelo.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>
                        Marca do modelo
                    </td>
                    <td><select name="select_marca" id="marca" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${modelo.marca.id == null}"> selected</c:if></option>
                            <c:forEach items="${marcas}" var="marca">
                                <option value="${marca.id}" <c:if test="${modelo.idPrimariaMarca == marca.id}"> selected</c:if>>${marca.nome}</option>
                            </c:forEach>
                        </select>
                </tr>

                <button type="submit" >Cadastrar</button>
        </form>
    </table>
    <br><br>
    <form action="ManterMarcaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterMarca">
        <table border="1"> 
            <tr>
                <td>ID da marca</td>
                <td><input type="number" name="txtId" value="${marca.id}"></td>
            </tr>
            <tr>
                <td>Nome da Marca</td>
                <td><input type="text" name="txtNome" value="${marca.nome}"></td>
            </tr>
            <tr >
                <td colspan="2"><button type="submit">Submit</button></td>
            </tr>
        </table



    </form>

</body>
</html>