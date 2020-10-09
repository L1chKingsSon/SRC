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
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Nota Fiscal
        </h1>
        <form action="ManterNotaFiscalController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterNotaFiscal" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td><input type="number" name="txtId" value="${notaFiscal.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Data</td>
                        <td><input type="number" name="txtData" value="${notaFiscal.data}" placeholder="MM/DD/AAAA" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <td><input type="number" name="txtValor" value="${notaFiscal.valor}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Tipo Transação</td>
                        <td><select name="Select_transacao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                                <option value='VENDA' <c:if test="${notaFiscal.transacao == 'VENDA'}"> selected</c:if> >Venda</option>
                                <option value='COMPRA' <c:if test="${notaFiscal.transacao == 'COMPRA'}"> selected</c:if> >Compra</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Funcionario Responsavel</td>
                        <td><select name="Select_funcionario" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${notaFiscal.funcionario.id == null}"> selected</c:if></option>
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <option value="${funcionario.id}" <c:if test="${notaFiscal.idPrimariaFuncionario == funcionario.id}"> selected</c:if>>${funcionario.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Cliente Envolvido</td>
                    <td><select name="Select_cliente" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${notaFiscal.cliente.id == null}"> selected</c:if></option>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${notaFiscal.idPrimariaCliente == cliente.id}"> selected</c:if>>${cliente.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>
            </table>
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
                if (form.txtId.value == "") {
                    mensagem = mensagem + "Informe o Código da Nota\n";
                }
                if (form.txtData.value == "") {
                    mensagem = mensagem + "Informe uma Data!\n";
                }
                if (form.txtValor.value == "") {
                    mensagem = mensagem + "Informe um Valor!\n";
                }
//                if (!campoNumerico(form.txtValor.value)) {
//                    mensagem = mensagem + "Valor deve ser Numérico!\n";
//                }
                if (!campoNumerico(form.txtId.value)) {
                    mensagem = mensagem + "Id deve ser Númerico!\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }

        </SCRIPT> 
        <a href="index.jsp" class="homelink">home</a>
    </body>
</html>
