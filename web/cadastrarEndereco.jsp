<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Endereço</title>
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
                Cadastrar Endereco
            </h1>
            <form action="ManterEnderecoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEndereco">
                <table border="1"> 
                    <tr>
                        <td>ID do endereco</td>
                        <td><input type="number" name="txtId" value="${endereco.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>cep</td>
                        <td><input type="text" name="txtCep" value="${endereco.cep}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>uf</td>
                        <td><input type="text" name="txtUF" value="${endereco.uf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>cidade</td>
                        <td><input type="text" name="txtCidade" value="${endereco.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>bairro</td>
                        <td><input type="text" name="txtBairro" value="${endereco.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>logradouro</td>
                        <td><input type="text" name="txtLogradouro" value="${endereco.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>numero</td>
                        <td><input type="text" name="txtNumero" value="${endereco.numero}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>complemento</td>
                        <td><input type="text" name="txtComplemento" value="${endereco.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Confirmar</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
