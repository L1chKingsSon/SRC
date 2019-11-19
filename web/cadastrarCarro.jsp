<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Carros</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <form action="ManterCarroController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCarro">
        <label>id</label>
        <input type="number" name="txtId" value="${carro.id}" <c:if test="${operacao == 'Editar'}"> readonly </c:if>  <c:if test="${operacao == 'Excluir'}"> readonly </c:if>  >
        <br>
        <br>
        <label>cor</labe>
        <input type="text" name="txtCor" value="${carro.cor}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>Placa</label>
        <input type="text" name="txtPlaca" value="${carro.placa}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>Chassi </label>
        <input type="text" name="txtChassi" value="${carro.chassi}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>ano do carro</label>
        <input type="text" name="txtAno" value="${carro.ano}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>IPVA pago</label>
        <input type="text" name="txtIpva" value="${carro.IPVA}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>data até onde o seguro foi pago</label>
        <input type="text" name="txtSeguro" value="${carro.seguro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>data até onde tem garantia</label>
        <input type ="text" name="txtGarantia" value="${carro.garantia}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>Valor comprado</label>
        <input type="number" name="txtValorComprado" value="${carro.valorComprado}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
        <br>
        <label>Modelo: </label>
        <select name="txtSelect_Modelo" id="modelo" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${carro.modelo.id == null}"> selected</c:if></option>
                            <c:forEach items="${modelos}" var="modelo">
                                <option value="${modelo.id}" <c:if test="${carro.idPrimariaModelo == modelo.id}"> selected</c:if>> ${modelo.nome} </option>
                            </c:forEach>
        </select>
        <br>
        <br>
        <label>Estacionamento<label>
    <select name="txtSelect_Estacionamento" id="estacionamento" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${carro.estacionamento.id == null}"> selected</c:if></option>
                            <c:forEach items="${estacionamentos}" var="estacionamento">
                                <option value="${estacionamento.id}" <c:if test="${carro.idPrimariaEstacionamento == estacionamento.id}"> selected</c:if>>${estacionamento.id}</option>
                            </c:forEach>
                        </select>
        <br>
        <br>
        <label>valor de venda</label>   
        <input type="number" name="txtValorVenda" value="${carro.valorComprado}">
        
    
    <button type="submit">Confirmar</button>
    </form>
        <a href="index.jsp">home</a>
    </body>
</html>
