<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem-vindos</title>
</head>
<body>
	<%--Comentário em jsp: Minha primeira página --%>
	
	<%String mensagem = "Bem vindos ao sistema de agendas Fj21!!";%>
	<%out.println(mensagem); %>
	
	<br />
	
	<%String desenvolvido = "Desenvolvido por Liliane de Aquino";%>
	<%= desenvolvido %>
	
	<br />
	
	<%System.out.println("Tudo foi executado"); %>	
</body>
</html>