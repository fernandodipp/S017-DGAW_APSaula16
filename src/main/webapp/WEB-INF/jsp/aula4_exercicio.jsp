<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.aula.Pet,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
<form action="cadastraForm4" method="post">
Nome Produto:<input type="text" name="nome" />
<br>
<br>
Preço Produto:<input type="number" name="preco" />
<input type="submit" value="enviar" />
</form>
<%
/* Produto produto = new Produto(); */
ArrayList<Pet> listaProdutos = (ArrayList<Pet>) 
application.getAttribute("lista_produtos");
for (Pet p : listaProdutos) {
	out.println("Nome Produto: " + p.nome);
	out.println("<br>");
	out.println("Nome Produto: " + p.preco);
	out.println("<br>");
	out.println("<br>");

}
%>
</body>
</html>