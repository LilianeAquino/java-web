<%@ page
	import="
	java.util.*,
	br.com.liliane.dao.*,
	br.com.liliane.modelo.*"%>

<html>
<body>
	<table>

		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();

			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
		    <td><%=contato.getDataNascimento().getTime()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>