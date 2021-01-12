<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List, br.com.alura.gerenciador.servelet.*"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard TagLib</title>
</head>
<body>

	Lista de Empresas: <br/>
	
	<ul> 
		<c:forEach items="${empresas}" var="empresa">  <%//aqui estamos usando jstl com expression language  jstl -> <c:forEach items=  expression language -> ${empresas} %>
		<li>
			${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/RemoveEmpresaServlet?id=${empresa.id}">remover</a>
			<a href="/gerenciador/EditarEmpresaServelet?id=${empresa.id}">editar</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>