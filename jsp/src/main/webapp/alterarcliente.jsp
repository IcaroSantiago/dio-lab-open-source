<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <title>Alterar Cliente</title>
</head>
<body>
    <div align="center">
        <h1>Alterar Cliente</h1>
        <form action="cliente?action=atualizar" method="post">
            ID do Cliente: <input type="text" name="id" value="${cliente.id}" ><br><br>
            Nome: <input type="text" name="nome" value="${cliente.nome}"><br><br>
            Sobrenome: <input type="text" name="sobrenome" value="${cliente.sobrenome}"><br><br>
            Login: <input type="text" name="login" value="${cliente.login}"><br><br>
            Senha: <input type="text" name="senha" value="${cliente.senha}"><br><br>
            Endereço: <input type="text" name="endereco" value="${cliente.endereco}"><br><br>
            Contato: <input type="text" name="contato" value="${cliente.contato}"><br><br>
            <input class="crud-btn update-btn" type="submit" value="Atualizar">
        </form>
        <br>
        <button class="crud-btn read-btn" onclick="window.location.href = 'consultacliente.jsp';">Voltar para Consulta de Clientes</button>
    </div>
</body>
</html>
