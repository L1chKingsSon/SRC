<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

        <header>
            <h1>Cadastro de Estacionamento</h1>
        </header>

        <form action="ManterEstacionamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEstacionamento" onsubmit="return validarFormulario(this)">
        <label>ID</label>
        <input type="number" name="txtId" value="${estacionamento.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> > </td>
    <br>
    <br>
        <label>Numero de Vagas: </label> <input type="number" name="txtVagas" value="${estacionamento.numeroVagas}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
        <br>
    <br>
    <br>
    <label>Endereco<label>
    <select name="txtSelect_Endereco" id="endereco" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${estacionamento.endereco.id == null}"> selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.id}" <c:if test="${estacionamento.idPrimariaEndereco == endereco.id}"> selected</c:if>>${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento} </option>
                            </c:forEach>
                        </select>
                            <br><br>
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
                    mensagem = mensagem + "Informe o Código do Endereco\n";
                }
                if (form.txtVagas.value == ""){
                    mensagem = mensagem + "Informe uma vaga!\n";
                }
                if (!campoNumerico(form.txtVagas.value)){
                    mensagem = mensagem + "Vagas devem ser Númericas!\n";
                }
                if (!campoNumerico(form.txtId.value)){
                    mensagem = mensagem + "Id deve ser Númerico!\n";
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
</body>
</html>