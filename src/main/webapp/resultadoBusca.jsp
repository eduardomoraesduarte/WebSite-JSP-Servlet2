<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados da Busca</title>
</head>
<body>
    <h1>Resultados da Busca</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Online</th>
        </tr>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            if (produtos != null && !produtos.isEmpty()) {
                for (Produto produto : produtos) {
        %>
                    <tr>
                        <td><%= produto.getIdProduto() %></td>
                        <td><%= produto.getDescricao() %></td>
                        <td><%= produto.getQuantidade() %></td>
                        <td><%= produto.getPreco() %></td>
                        <td><%= produto.isOnLine() ? "Sim" : "Não" %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="5">Nenhum produto encontrado.</td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>