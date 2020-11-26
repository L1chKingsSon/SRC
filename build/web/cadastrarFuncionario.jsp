<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Funcionario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="main.js"></script>
    </head>
    <body>
        <h1>
            Cadastrar Funcionario
        </h1>
        <table border="1">
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario" onsubmit="return validarFormulario(this)">
                <tr>
                    <td>ID Funcionario</td>
                    <td><input name="txtId" type="text" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td><input name="txtNome" type="text" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>CPF</td>
                        <td><input name="txtCpf" type="number" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Telefone</td>
                        <td><input type="text" name="txtTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Salario</td>
                        <td><input type="number" name="txtSalario" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Nome para Login</td>
                        <td><input type="text" name="txtLogin" value="${funcionario.login}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Senha</td>
                        <td><input type="password" name="txtSenha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Admin:</td>
                        <td><input type="checkbox" name="txtNivelAcesso" value="Admin" id="Admin" <c:if test="${funcionario.nivelAcesso == true}">checked</c:if> <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Endereco</td>
                            <td><select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${funcionario.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Conta do banco</td>
                    <td><select name="txtSelect_ContaBanco" id="contaBanco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.contaBanco.id == null}"> selected</c:if></option>
                            <c:forEach items="${contasBanco}" var="contaBanco">
                                <option value="${contaBanco.id}" <c:if test="${funcionario.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>conta: ${contaBanco.conta}, agencia: ${contaBanco.agencia}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr >
                    <td colspan="2"><input type="submit" name="btnConfirmar" value="Confirmar" class="buttonSubmit"></td>
                </tr>

<!--<input type="checkbox" name="txtNivelAcesso" value="Admin" <c:if test="${funcionario.nivelAcesso == true}"> checked </c:if> > <br>
                -->
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
                mensagem = mensagem + "Informe o Código do Funcionario\n";
            }
            if (form.txtNome.value == "") {
                mensagem = mensagem + "Informe um Nome!\n";
            }
            if (form.txtCpf.value == "") {
                mensagem = mensagem + "Informe um CPF!\n";
            }
            if (form.txtTelefone.value == "") {
                mensagem = mensagem + "Informe um Telefone!\n";
            }
            if (form.txtSalario.value == "") {
                mensagem = mensagem + "Informe um Salario!\n";
            }
            if (form.txtLogin.value == "") {
                mensagem = mensagem + "Informe um nome de Login!\n";
            }
            if (form.txtSenha.value == "") {
                mensagem = mensagem + "Informe uma Senha!\n";
            }
            if (!campoNumerico(form.txtId.value)) {
                mensagem = mensagem + "Id deve ser Númerico!\n";
            }
            if (!campoNumerico(form.txtCpf.value)) {
                mensagem = mensagem + "CPF deve ser Númerico!\n";
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
