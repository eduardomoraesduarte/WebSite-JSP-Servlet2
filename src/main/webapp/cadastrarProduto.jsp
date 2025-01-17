<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Style.css">

<meta charset="ISO-8859-1">
<title>Pagina</title>
</head>
<body>
	<nav class="cssNav">
		<ul>
			<li><a href="cadastrarProduto.jsp" class="active">Home</a></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>

	</nav>
	<main class="cssMain">
		<form name="frmProduto"
			action="${pageContext.request.contextPath}/publica?acao=inserir"
			onsubmit="return validar()" method="post" class="cssForm">

			<div class="campo">
				<label for="descricao"><strong>Descrição:</strong></label> <input
					type="text" name="descricao" id="descricao">
			</div>
			<div class="campo" >
				<label for="quantidade"><strong>Quantidade:</strong></label> <input
					type="text" name="quantidade" id="quantidade">
			 
				<label for="preco"><strong>Preço:</strong></label> <input
					type="text" name="preco" id="preco">
			</div>		
			<div class="campo-checkbox">
			    <label for="online">Disponível On-Line:</label>
			    <input id="online" type="checkbox" name="online">

				<input class="botao" id="cssButton" type="submit" name="salvar"
					value="Cadastrar Produto">
			</div>
		</form>
		<div>
				<% String mensagem = (String) request.getAttribute("mensagem"); 
				if (mensagem != null)
				out.print(mensagem);
				%>
			</div>
	</main>
	
	<script src="scripts/validador.js"></script>
</body>
</html>