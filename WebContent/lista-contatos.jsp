<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="liliane" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="campoData" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de contatos</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />		

		<form action="ListaContatoLogic"  method="post">
			
			<table width="100%" border="1">
			
				<tr bgcolor="aaeeee">
					<td>Nome</td>
					<td>Email</td>
					<td>Endereco</td>
					<td>Data de Nascimento</td>
					<td>Editar</td>
					<td>Excluir</td>
				</tr>
		
		        <c:forEach var="contato" items="${contatos}">
		            <tr>
		            
		                <td>${contato.nome}</td>
		                
		                <td>
						   <c:choose>
						      <c:when test="${not empty contato.email}">
							      <a href="mailto:${contato.email}">${contato.email}</a>
							  </c:when>
							  <c:otherwise>
							      E-mail não informado
							  </c:otherwise>
							</c:choose>
		                </td>
		                
		                <td>${contato.endereco}</td>
		                
		                <td><fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
		                
						<td><a href="mvc?logica=AlteraContatoLogic&paramAltera=popula&id=${contato.id}">Editar</a></td>
			            <td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
			            
		            </tr>
		        </c:forEach>
		        
				<tr bgcolor="aaeeee">
					<td><input type="text" name="nome"></td>
					<td><input type="text" name="email"></td>
					<td><input type="text" name="endereco"></td>
					<td><liliane:campoData id="dataNascimento" /></td>
					<td><input type="hidden" name="logica" value="AdicionaContatoLogic"><input type="submit" value="adicionar"></td>
				</tr>
				
		    </table>
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>