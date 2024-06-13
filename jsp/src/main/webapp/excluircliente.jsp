<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <title>Excluir Cliente</title>
</head>
<body>
    <div align="center">
        <h1>Excluir Cliente</h1>
        <form action="cliente?action=excluir" method="post">
            ID do Cliente: <input type="text" name="id"><br><br>
            <input class="crud-btn delete-btn" type="submit" value="Excluir">
        </form>
        <br>
        <button class="crud-btn read-btn" onclick="window.location.href = 'consultacliente.jsp';">Voltar para Consulta de Clientes</button>
    </div>
</body>
</html>
