<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Cliente</title>
</head>
<body>
	<div align="center">
		<h1>Formulário de Cadastrar Cliente</h1>
		<form action="cliente?action=registrar" method="post">
			<table style="width: 80%" >
				<tr>
					<td>Nome</td>
					<td><input type="text" name="nome"/></td>
				</tr>	
				<tr>
					<td>SobreNome</td>
					<td><input type="text" name="sobrenome"/></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login"/></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="password" name="senha"/></td>
				</tr>
				<tr>
					<td>Endereco</td>
					<td><input type="text" name="endereco"/></td>
				<tr/>
				<tr>
					<td>Contato</td>
					<td><input type="text" name="contato"/></td>
				</tr>			
			</table>
			<br><br>
			<input type="submit" class="crud-btn create-btn input-button" value="Cadastrar">
		</form>
	</div>
	<br>
	<br>
	<div align="center">
		<button class="crud-btn read-btn"  onclick="window.location.href = 'consultacliente.jsp';">Consultar</button>
		<button class="crud-btn update-btn" onclick="window.location.href = 'alterarcliente.jsp';">Alterar Cliente</button>
        <button class="crud-btn delete-btn" onclick="window.location.href = 'excluircliente.jsp';">Excluir Cliente</button>
	</div>
</body>
</html>