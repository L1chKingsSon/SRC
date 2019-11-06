<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Funcionario</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <h1>
        Cadastrar Funcionario
    </h1>

    <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario">
    <label>ID Funcionario</label>
    <input name="txtId" type="text" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ><br><br>
    
    <label>Nome</label>
    <input name="txtNome" type="text" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

    <label>CPF</label>
    <input name="txtCpf" type="number" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

    <br>
    
    <label>Telefone</label>
    <input type="text" name="txtTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>
    
    <label>Salario</label>
    <input type="number" name="txtSalario" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>
    
    <label>Nome para Login</label>d
    <input type="text" name="txtLogin" value="${funcionario.login}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

    <label>Senha</label>
    <input type="password" name="txtSenha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>


    <label>Admin: </label>
    
    <input type="checkbox" name="txtNivelAcesso" value="Admin" id="Admin" <c:if test="${funcionario.nivelAcesso == true}">checked</c:if> <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
    <br><br>
    
    <!--<input type="checkbox" name="txtNivelAcesso" value="Admin" <c:if test="${funcionario.nivelAcesso == true}"> checked </c:if> > <br>
  -->
  <label>Endereco<label>
    <select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${funcionario.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                            </c:forEach>
                        </select>
                            <br><br>
                            <label>Conta do banco</label>
    <select name="txtSelect_ContaBanco" id="contaBanco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.contaBanco.id == null}"> selected</c:if></option>
                            <c:forEach items="${contasBanco}" var="contaBanco">
                                <option value="${contaBanco.id}" <c:if test="${funcionario.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>conta: ${contaBanco.conta}, agencia: ${contaBanco.agencia}</option>
                            </c:forEach>
                        </select>
  
    <button type="submit">Cadastrar</button>
</form> 
<a href="index.jsp">home</a>
</body>
</html>
