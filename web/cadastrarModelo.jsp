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
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Modelo
        </h1>
        <form action="ManterModeloController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterModelo" onsubmit="return validarFormulario(this)">
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
                <tr >
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>
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
                    mensagem = mensagem + "Informe o Código do Modelo\n";
                }
                if (form.txtNome.value == "") {
                    mensagem = mensagem + "Informe um Nome!\n";
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
    </table>
    <a href="index.jsp" class="homelink">home</a>
</body>
</html>