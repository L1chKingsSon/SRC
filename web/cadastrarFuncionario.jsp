<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Funcionario</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <h1>
        Cadastrar Funcionario
    </h1>

    <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario">
    Funcionario
    <label>ID Funcionario</label>
    <input name="txtId" type="text" value="${funcionario.id}"><br><br>
    
    <label>Nome</label>
    <input name="txtNome" type="text" value="${funcionario.nome}"><br><br>

    <label>CPF</label>
    <input name="txtCpf" type="number" value="${funcionario.cpf}"><br><br>
    Endereco
<!--    <label>ID Endereco</label>
    <input name="idendereco" type="number" value="${endereco.id}"><br><br>
    
    <label>CEP</label>
    <input name="cep" type="number" value="${endereco.cep}"><br><br>

    <label>UF</label>
    <select name="uf" value="${endereco.uf}">

    </select><br><br>

    <label>Cidade</label>
    <input name="cidade" type="text" value="${endereco.cidade}"><br><br>

    <label>Bairro</label>
    <input name="bairro" type="text" value="${endereco.bairro}"><br><br>
    
    <label>Logradouro</label>
    <input name="logradouro" type="text" value="${endereco.logradouro}"><br><br>
       
    <label>Numero</label>
    <input name="numero" type="number" value="${endereco.numero}"><br><br>

    <label>Complemento</label>
    <input name="complemento" type="text" value="${endereco.complemento}"><br><br>   
    
    <label>Telefone p/ contato</label>
    <input name="telefone" type="number" value="${funcionario.telefone}"><br><br>   
     
    <label>Email</label>
    <input name="email" type="text"><br><br>
     conta do banco
     <label>ID Conta Banco</label>
     <input name="idcontabanco" type="number" value="${contaBanco.id}"><br><br>
     
    <label>Conta no Banco</label>
    <input name="contabanco" type="number" value="${contaBanco.numero}"><br><br>

    <label>Agencia</label>
    <input name="agencia" type="number" value="${contaBanco.agencia}"><br><br>

    <label>Tipo de Conta</label><br>
    <input name="tipoConta" type="radio" value="${contaBanco.tipo}">Corrente<br>
    <input name="tipoConta" type="radio" value="${contaBanco.tipo}">Poupanca<br><br>-->

    Dados de Login<br>
    <label>Nome para Login</label>d
    <input type="text" name="txtLogin" value="${funcionario.login}"><br><br>

    <label>Senha</label>
    <input type="password" name="txtSenha" value="${funcionario.senha}"><br><br>

    <label>Salario</label>
    <input type="number" name="txtSalario" value="${funcionario.salario}"><br><br>
    
    <label>Nivel de acesso</label>
    <input type="checkbox" name="txtNivelAcesso" value="Admin" <c:if test="${funcionario.nivelAcesso == true}">checked</c:if>><br>
  
    <button type="submit">Cadastrar</button>
</form>    
</body>
</html>
