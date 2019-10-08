<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Modelo e/ou Marca</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
<h1>
        Cadastrar Modelo e/ou Marca
    </h1>
    <form action="ManterModeloController?acao=confirmarOperacao&Operacao&operacao">
        <label>Nome do Modelo</label>
        <input type="text" name="modelo">

        <button type="submit">Cadastrar</button>
    </form>
    <br><br>
    <form action="ManterMarcaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterMarca">
        <table border="1"> 
            <tr>
                <td>ID da marca</td>
                <td><input type="number" name="txtId" value="${marca.id}"></td>
            </tr>
            <tr>
                <td>Nome da Marca</td>
                <td><input type="text" name="txtNome" value="${marca.nome}"></td>
            </tr>
        </table


        <button type="submit">Cadastrar</button>
    </form>

<!--    <form action="CADASTRAR">
        <label>Nome da Marca</label>
        <input type="text" name="marca">

        <label>Nome da Modelo</label>
        <input type="text" name="modelo">

        <button type="submit">Cadastrar</button>
    </form>-->
    
</body>
</html>