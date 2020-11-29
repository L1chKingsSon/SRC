<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filtrar Marcas</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Relatório 2 (com filtro)</h1>
        <form action="Relatorio2Controller?acao=emitir" method="post">
            Escolha a marca
            <select name="txtCodMarca">
                <c:forEach items="${marcas}" var="marca">
                    <option value="${marca.id}">${marca.nome}</option>  
                </c:forEach>
            </select>
            <br/>
            <input type="submit"/>
        </form>
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
