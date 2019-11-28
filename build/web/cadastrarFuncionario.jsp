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
    <div id='corpo'>
        <h1 id="tititle">
            Cadastrar Funcionario
        </h1>

<<<<<<< HEAD
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario">
        <label>ID Funcionario</label>
        <input name="txtId" type="text" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ><br><br>
=======
    <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario" onsubmit="return validarFormulario(this)">
    <label>ID Funcionario</label>
    <input name="txtId" type="text" value="${funcionario.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ><br><br>
    
    <label>Nome</label>
    <input name="txtNome" type="text" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>
>>>>>>> 82637cd20acb8d66c456bb3e21a51e807aed035a

        <label>Nome</label>
        <input name="txtNome" type="text" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

        <label>CPF</label>
        <input name="txtCpf" type="number" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

        <br>

        <label>Telefone</label>
        <input type="text" name="txtTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

<<<<<<< HEAD
        <label>Salario</label>
        <input type="number" name="txtSalario" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

        <label>Nome para Login</label>d
        <input type="text" name="txtLogin" value="${funcionario.login}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>

        <label>Senha</label>
        <input type="password" name="txtSenha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> ><br><br>


        <label>Admin: </label>

        <input type="checkbox" name="txtNivelAcesso" value="Admin" id="Admin" <c:if test="${funcionario.nivelAcesso == true}">checked</c:if> <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br><br>

        <!--<input type="checkbox" name="txtNivelAcesso" value="Admin" <c:if test="${funcionario.nivelAcesso == true}"> checked </c:if> > <br>
      -->
      <label>Endereco<label>
        <select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                                <option value="0" <c:if test="${funcionario.endereco.id == null}"> selected</c:if></option>
                                <c:forEach items="${enderecos}" var="endereco">
                                    <option value="${endereco.id}" <c:if test="${funcionario.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                                </c:forEach>
                            </select>
                                <br><br>
                                <label>Conta do banco</label>
        <select name="txtSelect_ContaBanco" id="contaBanco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                                <option value="0" <c:if test="${funcionario.contaBanco.id == null}"> selected</c:if></option>
                                <c:forEach items="${contasBanco}" var="contaBanco">
                                    <option value="${contaBanco.id}" <c:if test="${funcionario.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>conta: ${contaBanco.conta}, agencia: ${contaBanco.agencia}</option>
                                </c:forEach>
                            </select>

        <button type="submit">Confirmar</button>
    </form> 
</div>
=======
    <label>Admin: </label>
    
    <input type="checkbox" name="txtNivelAcesso" value="Admin" id="Admin" <c:if test="${funcionario.nivelAcesso == true}">checked</c:if> <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
    <br><br>
    
    <!--<input type="checkbox" name="txtNivelAcesso" value="Admin" <c:if test="${funcionario.nivelAcesso == true}"> checked </c:if> > <br>
  -->
  <label>Endereco<label>
    <select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${funcionario.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                            </c:forEach>
                        </select>
                            <br><br>
                            <label>Conta do banco</label>
    <select name="txtSelect_ContaBanco" id="contaBanco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${funcionario.contaBanco.id == null}"> selected</c:if></option>
                            <c:forEach items="${contasBanco}" var="contaBanco">
                                <option value="${contaBanco.id}" <c:if test="${funcionario.idPrimariaContaBanco == contaBanco.id}"> selected</c:if>>conta: ${contaBanco.conta}, agencia: ${contaBanco.agencia}</option>
                            </c:forEach>
                        </select>
  
    <button type="submit">Confirmar</button>
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
                if (form.txtId.value == ""){
                    mensagem = mensagem + "Informe o Código do Cliente\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe um Nome!\n";
                }
		if (form.txtCpf.value == ""){
                    mensagem = mensagem + "Informe um CPF!\n";
                }
		if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe um Telefone!\n";
                }
                if (form.txtSalario.value == ""){
                    mensagem = mensagem + "Informe um Salario!\n";
                }
		if (form.txtLogin.value == ""){
                    mensagem = mensagem + "Informe um nome de Login!\n";
                }
		if (form.txtSenha.value == ""){
                    mensagem = mensagem + "Informe uma Senha!\n";
                }
                if (!campoNumerico(form.txtId.value)){
                    mensagem = mensagem + "Id deve ser Númerico!\n";
                }
                if (!campoNumerico(form.txtCpf.value)){
                    mensagem = mensagem + "CPF deve ser Númerico!\n";
                }
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>                           
<a href="index.jsp">home</a>
>>>>>>> 82637cd20acb8d66c456bb3e21a51e807aed035a
</body>
</html>
