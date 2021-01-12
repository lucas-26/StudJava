<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
 <c:url value="/AlterarEmpresaServelet" var="linkServletNovaEmpresa"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de cadastro da nova empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		DataAbertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${empresa.id}">
		<input type = "submit"/>

	</form>

</body>
</html>