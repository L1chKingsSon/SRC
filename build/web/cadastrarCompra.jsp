<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>

        <header>
            <h1>Cadastro de Compra</h1>
        </header>

        <form action="ManterCompraController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCompra" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td><input type="number" name="txtId" value="${compra.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Carro</td>
                        <td><select name="txtSelect_Carro" id="carro" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${compra.carro.id == null}"> selected</c:if></option>
                            <c:forEach items="${carros}" var="carro">
                                <option value="${carro.id}" <c:if test="${compra.idPrimariaCarro == carro.id}"> selected</c:if>>${carro.placa}, ${carro.cor}, ${carro.modelo} </option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr >
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
                    mensagem = mensagem + "Informe o Código da Compra\n";
                }
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