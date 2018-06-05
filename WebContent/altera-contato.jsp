	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="liliane" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Altera Contato</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<form action="mvc?logica=AlteraContatosLogic" method="post">
		
			Id: <input type="text" name="id" value="${param.id}" readonly style="border:none" /><br>
			Nome: <input type="text" name="nome" value="${requestScope.nome}"/><br>
			Endereco: <input type="text" name="endereco" value="${requestScope.endereco}" /><br>
			Email: <input type="text" name="email" value="${requestScope.email}" /><br>
			
			Data de Nascimento: <liliane:campoData id="dataNascimento" />
					
			<input type="hidden" name="logica" value="AlteraContatoLogic"/>
			<input type="hidden" name="paramAltera" value="altera"/><br><br>
			<input type="submit" value="Alterar"/>
			
		</form>
		
		<c:import url="rodape.jsp" />
	</body>
</html>