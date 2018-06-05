<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			<title>Formulário para remoção de contatos</title>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		</head>
		<body>
			<c:import url="cabecalho.jsp"/>	
			
			<form action="mvc?logica=RemoveContatosLogic" method="post">
			    Id:
			    <input type="text" name="id"/><br/>
			    <input type="hidden" name="logica" value="RemoveContatoLogic"/>
			    <input type="submit" value="Enviar"/>
			</form>
			
			<c:import url="rodape.jsp" />
		</body>
</html>