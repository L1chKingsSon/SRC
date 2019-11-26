<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

        <header>
            <h1>Cadastro de Venda</h1>
        </header>

        <form action="ManterVendaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterVenda" onsubmit="return validarFormulario(this)">
        <label>ID</label>
        <input type="number" name="txtId" value="${venda.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> > </td>
    <br>
    <br>
    <br>
    <label>Carro<label>
    <select name="txtSelect_Carro" id="carro" <c:if test="${operacao == 'Excluir'}"> readonly </c:if> >
                            <option value="0" <c:if test="${venda.carro.id == null}"> selected</c:if></option>
                            <c:forEach items="${carros}" var="carro">
                                <option value="${carro.id}" <c:if test="${venda.idPrimariaCarro == carro.id}"> selected</c:if>>${carro.placa}, ${carro.cor}, ${carro.modelo} </option>
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
                    mensagem = mensagem + "Informe o Código da Venda\n";
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