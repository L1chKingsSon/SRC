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
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Endereco
        </h1>
        <form action="ManterEnderecoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEndereco" onsubmit="return validarFormulario(this)">
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
                <tr >
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>
            </table



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
                    mensagem = mensagem + "Informe o Código do Endereco\n";
                }
                if (form.txtCep.value == "") {
                    mensagem = mensagem + "Informe um CEP!\n";
                }
                if (form.txtUF.value == "") {
                    mensagem = mensagem + "Informe um Estado!\n";
                }
                if (form.txtCidade.value == "") {
                    mensagem = mensagem + "Informe uma Cidade!\n";
                }
                if (form.txtBairro.value == "") {
                    mensagem = mensagem + "Informe um bairro!\n";
                }
                if (form.txtLogradouro.value == "") {
                    mensagem = mensagem + "Informe um logradouro!\n";
                }
                if (form.txtNumero.value == "") {
                    mensagem = mensagem + "Informe um numero!\n";
                }
                if (form.txtComplemento.value == "") {
                    mensagem = mensagem + "Informe um complemento!\n";
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
