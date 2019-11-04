<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Nota Fiscal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <h1>
        Cadastrar Nota Fiscal
    </h1>
    <form action="ManterModeloController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterModelo">
       <label>ID</label> 
       <input type="number" name="idnotafiscal" value="${nota.id}"><br><br> 
        
       <label>Data</label> 
       <input type="datetime-local" name="data" value="${nota.data}"><br><br>

       <label>Valor</label>
       <input type="number" name="valor" value="${nota.valor}"><br><br>

       <button type="submit">Cadastrar Nota</button>
    </form>
    
</body>
</html>
