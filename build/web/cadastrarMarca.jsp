<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Marca</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>
            Cadastrar Marca
        </h1>
        <form action="ManterMarcaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterMarca" onsubmit="return validarFormulario(this)">
            <table border="1">
                <tr>
                    <td>ID da marca</td>
                    <td><input type="number" name="txtId" value="${marca.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Nome da Marca</td>
                        <td><input type="text" name="txtNome" value="${marca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                </tr>
                <tr >
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
<!--

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
                    mensagem = mensagem + "Informe o Código da Marca\n";
                }
                if (form.txtNome.value == "") {
                    mensagem = mensagem + "Informe o Nome da Marca\n";
                }
                if (!campoNumerico(form.txtId.value)) {
                    mensagem = mensagem + "Código da Marca deve ser numérico\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
            //-->
        </SCRIPT>       
        <a href        ="index.jsp" class="homelink">home</a>       
    </body>
</html>