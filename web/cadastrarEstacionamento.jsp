<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

        <header>
            <h1>Cadastro de Estacionamento</h1>
        </header>

        <form action="ManterEstacionamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEstacionamento">
        <label>ID</label>
        <input type="number" name="txtId" value="${estacionamento.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> > </td>
    <br>
    <br>
        <label>Numero de Vagas: </label> <input type="number" name="txtVagas" value="${estacionamento.numeroVagas}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
    <br>
    <br>
    <label>Endereco<label>
    <select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${estacionamento.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${estacionamento.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                            </c:forEach>
                        </select>
                            <br><br>
<button type="submit">Cadastrar</button>
</form>  
</body>
</html>