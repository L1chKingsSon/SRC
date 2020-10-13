<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filtrar Carros por Modelo ou Marca</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Relatório 4 (com filtro)</h1>
        <form action="Relatorio4Controller?acao=emitir" method="post">
            Escolha a marca
            <select name="txtCodMarca">
                <c:forEach items="${marcas}" var="marca">
                    <option value="${marca.id}">${marca.nome}</option>  
                </c:forEach>
            </select>
            <br/>
            <input type="submit"/>
        </form>
        <form action="Relatorio4Controller?acao=emitir2" method="post">
            Escolha o modelo
            <select name="txtCodModelo">
                <c:forEach items="${modelos}" var="modelo">
                    <option value="${modelo.id}">${modelo.nome}</option>  
                </c:forEach>
            </select>
            <br/>
            <input type="submit"/>
        </form>
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
