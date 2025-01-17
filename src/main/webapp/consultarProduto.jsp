<%@ page import="com.deveduarteo.model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/Style.css">
    <title>Resultados da Busca</title>
</head>
<body>
    <nav class="cssNav">
        <ul>
            <li><span style="color: white">Home</span></li>
            <li><img src="img/bacana.png" height="20px"></li>
            <li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
            <li><a href="consultarProduto.jsp">Consultar Produto</a></li>
        </ul>
    </nav>
    <main class="cssMain">
        <form action="${pageContext.request.contextPath}/publica?acao=buscar" method="post" class="cssForm">
            <div>
                <label><strong>Busca pela Descrição:</strong></label>
                <input type="text" name="descricao" required>
            </div>
            <br>
            <div>
                <input class="botao" id="cssButton" type="submit" name="buscar" value="Consultar Produto">
            </div>
        </form>
      
        <div class="DivMother">
        	<div class="divItem">
        	<div class="divColumn">
        		<span style="font-weigth: bold">Id: </span>
        		<span> Conteudo</span> 
        	</div>
        	<div class="divColumn">
        		<span style="font-weigth: bold">Descrição: </span>
        		<span>Conteúdo</span> 
        	</div>
        	<div class="divColumn">
        		<span style="font-weigth: bold">Quantidade: </span>
        		<span>Conteúdo</span> 
        	</div>
        	</div>
        	<div class="divColumn">
        		<span style="font-weigth: bold">Preço: </span>
        		<span>Conteúdo</span> 
        	</div>
        	<div class="divColumn">
        		<span style="font-weigth: bold">Online: </span>
        		<span>Conteúdo</span> 
        	</div>
        	<div >
        		<input id="ItemButton" type="submit" name="alterar" value="Alterar">
        		<input id="ItemButton" type="submit" name="apagar" value="Apagar">
        		 
        	</div>
        </div>
    </main>
  
</body>
</html>