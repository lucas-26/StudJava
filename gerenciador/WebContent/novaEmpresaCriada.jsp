<%
	//o nome disso aqui é scriplet, código java no html
	String nomeEmpresa = (String)request.getAttribute("empresa");//usando o apelido que é enviado pelo NovaEmpresaServelet, retorna um objeto, então é necessário fazer um cast para string 
	System.out.println(nomeEmpresa);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso! 
</body>
</html>