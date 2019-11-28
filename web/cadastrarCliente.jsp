<%-- 
    Document   : cadastrarContaBanco
    Created on : 01/11/2019, 23:04:30
    Author     : Raphael
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <nav id="sidebar" class="navbar navbar-expand-lg navbar-light bg-dark">
            <ul class="list-unstyled ">
                <ul>
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                         <a href="PesquisaMarcaController">Manter Marcas</a>
                    </li>
                    <li>
                        <a href="PesquisaModeloController">Manter Modelos</a>
                    </li>
                    <li>
                        <a href="PesquisaCarroController">Manter Carros</a>
                    </li>
                    <li>
                         <a href="PesquisaContaBancoController">Manter Contas</a>
                    </li>
                    <li>
                         <a href="PesquisaClienteController">Manter Clientes</a>
                    </li>
                    <li>
                        <a href="PesquisaEnderecoController">Manter Enderecos</a>
                    </li>
                    <li>
                       <a href="PesquisaEstacionamentoController">Manter Estacionamentos</a>
                    </li>
                    <li>
                        <a href="PesquisaFuncionarioController">Manter Funcionarios</a>
                    </li>
                    <li>
                        <a href="PesquisaReservaController">Manter Reservas</a>
                    </li>
                    <li>
                        <a href="PesquisaCompraController">Manter Compras</a>
                    </li>
                    <li>
                        <a href="PesquisaVendaController">Manter Vendas</a>
                    </li>
                    <li>
                        <a href="PesquisaNotaFiscalController">Manter Notas Fiscais</a>
                    </li>
                </ul>
            </li>
         </nav>
        <h1>
            Cadastrar Cliente
        </h1>
    <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCliente" onsubmit="return validarFormulario(this)">
        <table border="1"> 
            <tr>
                <td>ID Cliente</td>
                <td><input type="number" name="txtId" value="${cliente.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Nome</td>
                <td><input type="text" name="txtNome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>CPF</td>
                <td><input name="txtCpf" type="number" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            <tr>
                <td>Telefone</td>
                <td><input type="text" name="txtTelefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
            </tr>
            
            <tr>
                <td>Endereco</td>
                <td>
                    <select name="txtSelect_endereco" id="endereco" >
                            <option value="0" <c:if test="${cliente.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${cliente.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, n ${endereco.numero}, ${endereco.complemento}</option>
                            </c:forEach>
                        </select>
                    
                </td>
            </tr>
            
            <tr>
                <td>Conta do Banco</td>
                <td>
                    <select name="txtSelect_conta" id="contaBanco" >
                            <option value="0" <c:if test="${cliente.contaBanco.id == null}"> selected</c:if></option>
                            <c:forEach items="${contaBancos}" var="contaBanco">
                                <option value="${contaBanco.id}" <c:if test="${cliente.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>${contaBanco.conta}, agencia ${contaBanco.agencia}</option>
                            </c:forEach>
                        </select>
                </td>
            </tr>
            
            <tr >
                <td colspan="2"><button type="submit">Confirmar</button></td>
            </tr>
        </table



    </form>
    <SCRIPT language="JavaScript">
            
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtId.value == ""){
                    mensagem = mensagem + "Informe o Código do Cliente\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe um Nome!\n";
                }
		if (form.txtCpf.value == ""){
                    mensagem = mensagem + "Informe um CPF!\n";
                }
		if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe um Telefone!\n";
                }
                if (!campoNumerico(form.txtId.value)){
                    mensagem = mensagem + "Id deve ser Númerico!\n";
                }
                if (!campoNumerico(form.txtCpf.value)){
                    mensagem = mensagem + "CPF deve ser Númerico!\n";
                }
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>                         
    <a href="index.jsp">home</a>

</body>
</html>