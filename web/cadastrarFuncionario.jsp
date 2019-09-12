<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Funcionário</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <h1>
        Cadastrar Funcionário
    </h1>

    <form action="CADASTRAR">
    Funcionário
    <label>Nome</label>
    <input name="nome" type="text"><br><br>

    <label>CPF</label>
    <input name="cpf" type="number"><br><br>
    Endereço
    <label>CEP</label>
    <input name="cep" type="number"><br><br>

    <label>UF</label>
    <select name="uf">

    </select><br><br>

    <label>Cidade</label>
    <input name="cidade" type="text"><br><br>

    <label>Bairro</label>
    <input name="bairro" type="text"><br><br>
    
    <label>Logradouro</label>
    <input name="logradouro" type="text"><br><br>
       
    <label>Numero</label>
    <input name="numero" type="number"><br><br>

    <label>Complemento</label>
    <input name="complemento" type="text"><br><br>   
    
    <label>Telefone p/ contato</label>
    <input name="telefone" type="number"><br><br>   
     
    <label>Email</label>
    <input name="email" type="text"><br><br>
     conta do banco
    <label>Conta no Banco</label>
    <input name="contabanco" type="number"><br><br>

    <label>Agencia</label>
    <input name="agencia" type="number"><br><br>

    <label>Tipo de Conta</label><br>
    <input name="tipoConta" type="radio" value="cc">Corrente<br>
    <input name="tipoConta" type="radio" value="cp">Poupança<br><br>

    Dados de Login<br>
    <label>Nome para Login</label>
    <input type="text" name="login"><br><br>

    <label>Senha</label>
    <input type="password" name="senha"><br><br>

    <label>Salário</label>
    <input type="number"><br><br>
       
    <button type="submit">Cadastrar</button>
</form>    
</body>
</html>
