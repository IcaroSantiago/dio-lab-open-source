<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Tela de Login</title>
<style>
body {
	background: rgb(9, 9, 121);
	background: linear-gradient(97deg, rgba(9, 9, 121, 1) 0%,
		rgba(0, 212, 255, 1) 46%);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}
</style>

</head>
<body>
	<div align="center">
		<form action="login" method="post">
			<h2>Login</h2>
			<%
			if (request.getAttribute("error") != null) {
			%>
			<p style="color: red;"><%=request.getAttribute("error")%></p>
			<%
			}
			%>
			<label for="login">Login:</label> <input type="text" id="login"
				name="login" placeholder="Digite seu login" required><br>
			<br> <label for="senha">Senha:</label> <input type="password"
				id="senha" name="senha" placeholder="Digite sua senha" required><br>
			<br>
			<button class="crud-btn create-btn input-button" type="submit">Login</button>
			<br><br>
			<button class="crud-btn create-btn input-button" onclick="window.location.href = 'registracliente.jsp';">Cadastrar Cliente</button>
		</form>
	</div>
</body>
</html>
