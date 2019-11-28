<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Modelo</title>
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
        <div id="corpo">
            <h1 id="tititle">
                Cadastrar Modelo
            </h1>
            <form action="ManterModeloController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterModelo">
                <table border="1">
                    <tr>
                        <td>ID do Modelo</td>
                        <td>
                    <input type="number" name="txtId" value="${modelo.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </td>
                    </tr>
                    <tr>
                        <td>Nome do Modelo</td>
                        <td><input type="text" name="txtNome" value="${modelo.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>
                            Marca do modelo
                        </td>
                        <td><select name="txtSelect_marca" id="marca" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                                <option value="0" <c:if test="${modelo.marca.id == null}"> selected</c:if></option>
                                <c:forEach items="${marcas}" var="marca">
                                    <option value="${marca.id}" <c:if test="${modelo.idPrimariaMarca == marca.id}"> selected</c:if>>${marca.nome}</option>
                                </c:forEach>
                            </select>
                        <td>
                    </tr>

                    <button type="submit" >Confirmar</button>
            </form>
        </table>
        </form>
</div>
</body>
</html>