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
       <input type="number" name="idnotafiscal" value="${notaFiscal.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ><br><br> 
        
       <label>Data</label> 
       <input type="datetime-local" name="data" value="${notaFiscal.data}"><br><br>

       <label>Valor</label>
       <input type="number" name="valor" value="${notaFiscal.valor}"><br><br>
       
       <select>
           <option value="0" <c:if test="${modelo.marca.id == null}"> selected</c:if></option>
                            <c:forEach items="${marcas}" var="marca">
                                <option value="${marca.id}" <c:if test="${modelo.idPrimariaMarca == marca.id}"> selected</c:if>>${marca.nome}</option>
                            </c:forEach>
       </select>

       <button type="submit">Cadastrar Nota</button>
    </form>
    
</body>
</html>
