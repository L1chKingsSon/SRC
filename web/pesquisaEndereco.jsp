<%-- 
    Document   : pesquisaEndereco
    Created on : 26/09/2019, 08:55:53
    Author     : jafar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Endereços</title>
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
        <div id="corpo">
                <h1 id="tititle">Pesquisa de Endereços</h1>
            <table border="1" id="tbl">
                <tr>
                    <th>ID do endereço</th>
                    <th>CEP</th>
                    <th>UF</th>
                    <th>Cidade</th>
                    <th>Bairro</th>
                    <th>Logradouro</th>
                    <th>Numero</th>
                    <th>Complemento</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${enderecos}" var="endereco">
                    <tr>
                        <td><c:out value="${endereco.id}" /></td>
                        <td><c:out value="${endereco.cep}" /></td>
                        <td><c:out value="${endereco.uf}" /></td>
                        <td><c:out value="${endereco.cidade}" /></td>
                        <td><c:out value="${endereco.bairro}" /></td>
                        <td><c:out value="${endereco.logradouro}" /></td>
                        <td><c:out value="${endereco.numero}" /></td>
                        <td><c:out value="${endereco.complemento}" /></td>
                        <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${endereco.id}"/>">Editar</a></td>
                        <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${endereco.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
             <form action="ManterEnderecoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
