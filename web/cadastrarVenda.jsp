<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

        <header>
            <h1>Cadastro de Venda</h1>
        </header>

        <form action="ManterVendaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterVenda">
        <label>ID</label>
        <input type="number" name="txtId" value="${venda.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> > </td>
    <br>
    <br>
    <br>
    <label>Carro<label>
    <select name="txtSelect_Carro" id="carro" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${venda.carro.id == null}"> selected</c:if></option>
                            <c:forEach items="${carros}" var="carro">
                                <option value="${carro.id}" <c:if test="${venda.idPrimariaCarro == carro.id}"> selected</c:if>>${carro.placa}, ${carro.cor}, ${carro.modelo} </option>
                            </c:forEach>
                        </select>
                            <br><br>
<button type="submit">Confirmar</button>
</form>  
    <a href="index.jsp">home</a>
</body>
</html>