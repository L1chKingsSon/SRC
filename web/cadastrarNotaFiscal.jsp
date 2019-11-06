<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Nota Fiscal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <h1>
        Cadastrar Nota Fiscal
    </h1>
    <form action="ManterNotaFiscalController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterNotaFiscal">
       <label>ID</label> 
       <input type="number" name="txtId" value="${notaFiscal.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ><br><br> 
        
       <label>Data</label> 
       <input type="date" name="txtData" value="${notaFiscal.data}" placeholder="MM/DD/AAAA" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

       <label>Valor</label>
       <input type="number" name="txtValor" value="${notaFiscal.valor}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>
       
       <label>Tipo Transação</label>
       <select name="Select_transacao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
           <option value=true>Venda</option>
           <option value=false>Compra</option>
        </select><br><br>
       
       <label>Funcionario Responsavel</label>
       <select name="Select_funcionario" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
           <option value="0" <c:if test="${notaFiscal.funcionario.id == null}"> selected</c:if></option>
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <option value="${funcionario.id}" <c:if test="${notaFiscal.idPrimariaFuncionario == funcionario.id}"> selected</c:if>>${funcionario.nome}</option>
                            </c:forEach>
       </select><br><br>
       
       <label>Cliente Envolvido</label>
       <select name="Select_cliente" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
           <option value="0" <c:if test="${notaFiscal.cliente.id == null}"> selected</c:if></option>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${notaFiscal.idPrimariaCliente == cliente.id}"> selected</c:if>>${cliente.nome}</option>
                            </c:forEach>
       </select><br><br>

       <button type="submit">Submit</button>
    </form>
    <a href="index.jsp">home</a>
</body>
</html>
