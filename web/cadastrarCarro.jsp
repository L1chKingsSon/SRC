<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Carros</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Carro
        </h1>
        <form action="ManterCarroController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCarro" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tr>
                    <td>id</td>
                    <td><input type="number" name="txtId" value="${carro.id}" <c:if test="${operacao == 'Editar'}"> readonly </c:if>  <c:if test="${operacao == 'Excluir'}"> readonly </c:if>  ></td>
                    </tr>

                    <tr>
                        <td>cor</td>
                            <td><input type="text" name="txtCor" value="${carro.cor}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr> 
                    <tr>
                        <td>Placa</td>
                        <td><input type="text" name="txtPlaca" value="${carro.placa}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Chassi</td>
                        <td><input type="text" name="txtChassi" value="${carro.chassi}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>ano do carro</td>
                        <td><input type="text" name="txtAno" value="${carro.ano}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>data até onde o IPVA foi pago</td>
                        <td><input type="text" name="txtIpva" value="${carro.IPVA}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>data até onde o seguro foi pago</td>
                        <td><input type="text" name="txtSeguro" value="${carro.seguro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>data até onde tem garantia</td>
                        <td><input type ="text" name="txtGarantia" value="${carro.garantia}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Valor comprado</td>
                        <td><input type="number" name="txtValorComprado" value="${carro.valorComprado}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Modelo: </td>
                        <td><select name="txtSelect_Modelo" id="modelo" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${carro.modelo.id == null}"> selected</c:if></option>
                            <c:forEach items="${modelos}" var="modelo">
                                <option value="${modelo.id}" <c:if test="${carro.idPrimariaModelo == modelo.id}"> selected</c:if>> ${modelo.nome} </option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Estacionamento</td>
                    <td><select name="txtSelect_Estacionamento" id="estacionamento" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${carro.estacionamento.id == null}"> selected</c:if></option>
                            <c:forEach items="${estacionamentos}" var="estacionamento">
                                <option value="${estacionamento.id}" <c:if test="${carro.idPrimariaEstacionamento == estacionamento.id}"> selected</c:if>>${estacionamento.id}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>valor de venda</td>
                    <td><input type="number" name="txtValorVenda" value="${carro.valorVenda}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                </tr>
                <tr >
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>
            </table>
        </form>
        <a href="index.jsp" class="homelink">home</a>

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
                    mensagem = mensagem + "Informe o código do carro\n";
                }
                if (form.txtCor.value == "") {
                    mensagem = mensagem + "Informe a cor do carro\n";
                }
                if (form.txtPlaca.value == "") {
                    mensagem = mensagem + "Informe a placa do carro\n";
                }
                if (form.txtChassi.value == "") {
                    mensagem = mensagem + "Informe o chassi do carro\n";
                }
                if (form.txtAno.value == "") {
                    mensagem = mensagem + "Informe o ano do carro\n";
                }
                if (form.txtIpva.value == "") {
                    mensagem = mensagem + "Informe até que ano o IPVA do carro foi pago\n";
                }
                if (form.txtSeguro.value == "") {
                    mensagem = mensagem + "Informe até que ano o seguro do carro foi pago\n";
                }
                if (form.txtGarantia.value == "") {
                    mensagem = mensagem + "Informe até que ano a garantia do carro foi pago\n";
                }
                if (form.txtValorComprado.value == "") {
                    mensagem = mensagem + "Informe o valor que o carro foi comprado do cliente\n";
                }
                if (form.txtSelect_Modelo.value == "") {
                    mensagem = mensagem + "Informe o modelo do carro\n";
                }
                if (form.txtSelect_Estacionamento.value == "") {
                    mensagem = mensagem + "Informe em qual estacionamento o carro está guardado\n";
                }
                if (form.txtValorVenda.value == "") {
                    mensagem = mensagem + "Informe o valor que o carro será vendido\n";
                }
                if (!campoNumerico(form.txtId.value)) {
                    mensagem = mensagem + "Código do carro deve ser numérico\n";
                }
//                if (!campoNumerico(form.txtValorComprado.value)) {
//                    mensagem = mensagem + "Valor que o carro foi comprado deve ser numérico\n";
//                }
                if (!campoNumerico(form.txtSelect_Modelo.value)) {
                    mensagem = mensagem + "Código do modelo deve ser numérico\n";
                }
                if (!campoNumerico(form.txtSelect_Estacionamento.value)) {
                    mensagem = mensagem + "Código do estacionamento deve ser numérico\n";
                }
//                if (!campoNumerico(form.txtValorVenda.value)) {
//                    mensagem = mensagem + "Valor de venda do carro deve ser numérico\n";
//                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </SCRIPT>        
    </body>
</html>
