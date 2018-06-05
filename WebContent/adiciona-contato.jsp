<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="liliane" %>
          
<c:import url="cabecalho.jsp" />


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Formulário</title>
	
	<link href="css/jquery-ui.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
    
</head>
<body>
    <h1>Adiciona Contatos</h1>
    <hr />
    <form action="AdicionaContatoLogic" method="Post">
        Nome: <input type="text" name="nome" /><br />
        E-mail: <input type="text" name="email" /><br />
        Endereço: <input type="text" name="endereco" /><br />
        Data Nascimento: <liliane:campoData id="dataNascimento" /><br />
        <input type="submit" value="Gravar" />
    </form>
    
   <c:import url="rodape.jsp" />
</body>

</html>