<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Carros</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <label>Modelo: </label>
        <input type="text" name="modelo" placeholder="modelo do carro"><br><br>
        <label>Chassi: </label>
        <input type="text" name="chassi" placeholder="Chassi do carro"><br><br>
        <label>Ano:</label>
        <input type="number" name="ano" placeholder="Ano do carro"><br><br>

        <label>Marca:</label>
        <input type="text" name="marca" placeholder="Marca do carro"><br><br>
        <select name="txtSelect_marca" id="marca">
            <option value="0" <c:if test="${modelo.marca.id == null}"> selected</c:if></option>
        <c:forEach items="${marcas}" var="marca">
            <option value="${marca.id}" <c:if test="${modelo.idPrimariaMarca == marca.id}"> selected</c:if>>${marca.nome}</option>
        </c:forEach>
    </select>
    <label>Cor:</label>
    <input type="cor" name="cor" placeholder="Cor do carro"><br><br>
    <label>Placa:</label>
    <input type="text" name="placa" placeholder="Placa do carro"><br><br>
    <label>Valor do IPVA:</label>
    <input type="text" name="valorIPVA" placeholder="valor do IPVA"><br><br>
    <label>Seguro:</label>
    <input type="radio" name="seguro" value="true"> Tem
    <input type="radio" name="seguro" value="false"> Não tem <brss>
    <label>Se tiver seguro, até quando:</label>
    <input type="date" name="dataSeguro"><br><br>
    <label>Cliente</label>
    <input type="text" name="cliente" placeholder="cliente que vendeu o carro"><br><br>
    <label>Valor pago no carro:</label>
    <input type="number" name="valorComprado" placeholder="valor que o carro foi comprado"><br><br>
    <label>Estacionamento:</label>
    <select name="estacionamentos">
        <option value="estacionamento1">loja da rio branco</option>
        <option value="estacionamento2">loja do monte castelo</option>
    </select><br><br>

    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
    <button type="submit" value="Cadastrar" class="btn btn-primary">Cadastrar</button>
</body>
</html>
