<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %> 
<%@ page import="jsp.model.Cliente" %> 
<%@ page import="jsp.dao.ClienteDao" %> 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Consulta de Clientes</title>
</head>
<body>
    <div align="center">
        <button onclick="window.location.href = 'registracliente.jsp';">Voltar para Tela Principal</button>
        <button onclick="window.location.href = 'login.jsp';">Realizar o Login</button>
        <h1>Consultar Clientes</h1>
        <%
        jsp.dao.ClienteDao clienteDao = new jsp.dao.ClienteDao();
        List<Cliente> listaClientes = clienteDao.listaClientes();
        request.setAttribute("list", listaClientes);
        %>

        <table border="1" style="width: 50%" >
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Login</th>
                <th>Endereço</th>
                <th>Contato</th>
            </tr>
            <c:forEach var="cliente" items="${list}">
                <tr>
                    <td>${cliente.getId()}</td>
                    <td>${cliente.getNome()}</td>
                    <td>${cliente.getSobrenome()}</td>
                    <td>${cliente.getLogin()}</td>
                    <td>${cliente.getEndereco()}</td>
                    <td>${cliente.getContato()}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <button class="crud-btn create-btn input-button" onclick="window.location.href = 'registracliente.jsp';">Cadastrar Cliente</button>
        <button class="crud-btn update-btn" onclick="window.location.href = 'alterarcliente.jsp';">Alterar Cliente</button>
        <button class="crud-btn delete-btn" onclick="window.location.href = 'excluircliente.jsp';">Excluir Cliente</button>
    </div>
</body>
</html>
