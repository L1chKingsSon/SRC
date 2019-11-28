<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
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
        <header>
            <div id="corpo">
                    <h1 id="tititle">Cadastro de Estacionamento</h1>
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
        <button type="submit">Confirmar</button>
        </form>  
    </div>
</body>
</html>