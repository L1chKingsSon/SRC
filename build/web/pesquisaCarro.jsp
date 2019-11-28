<%-- 
    Document   : pesquisaCarro
    Created on : 20/09/2019, 14:58:44
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Carros</title>
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
            <h1 id="tititle">Pesquisa de Carros</h1>
            <table border="1" id="tbl">
                <tr>
                    <th>ID do carro</th>
                    <th>Cor</th>
                    <th>Placa do carro</th>
                    <th>Chassi</th>
                    <th>Ano</th>
                    <th>IPVA</th>
                    <th>Data Seguro</th>
                    <th>Data Garantia</th>
                    <th>Valor Comprado</th>
                    <th>Nome do Modelo</th>
                    <th>CEP do estacionamento</th>
                    <th>Valor de Venda</th>
                    <th colspan="2">Ação</th>
                    <!--<th>Nome da marca a qual pertence</th>-->
                </tr>
                <c:forEach items="${carros}" var="carro">
                    <tr>
                        <td><c:out value="${carro.id}" /></td>
                        <td><c:out value="${carro.cor}" /></td>
                        <td><c:out value="${carro.placa}" /></td>
                        <td><c:out value="${carro.chassi}" /></td>
                        <td><c:out value="${carro.ano}" /></td>
                        <td><c:out value="${carro.IPVA}" /></td>
                        <td><c:out value="${carro.seguro}" /></td>
                        <td><c:out value="${carro.garantia}" /></td>
                        <td><c:out value="${carro.valorComprado}" /></td>
                        <td><c:out value="${carro.modelo.nome}" /></td>
                        <td><c:out value="${carro.estacionamento.endereco.cep}" /></td>
                        <td><c:out value="${carro.valorVenda}" /></td>
                        <td><a href="ManterCarroController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${carro.id}"/>">Editar</a></td>
                        <td><a href="ManterCarroController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${carro.id}"/>">Excluir</a></td> 
                    </tr> 
                </c:forEach>
            </table>
            <form action="ManterCarroController?acao=prepararOperacao&operacao=Incluir" method="post">
             <button type="submit">Confirmar</button></td>
            </form>
        </div>
    </body>
</html>
