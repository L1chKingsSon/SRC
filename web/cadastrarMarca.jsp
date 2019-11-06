<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Marca</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <br><br>
        <form action="ManterMarcaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterMarca">
            <table border="1">
                <tr>
                    <td>ID da marca</td>
                    <td><input type="number" name="txtId" value="${marca.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Nome da Marca</td>
                <td><input type="text" name="txtNome" value="${marca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr >
                <td colspan="2"><button type="submit">Cadastrar</button></td>
            </tr>
            </table>
        </form>
    </body>
</html>