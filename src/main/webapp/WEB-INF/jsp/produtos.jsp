<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercicio E1 - Fernando</title>
<style type="text/css">
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 75%;
  border: 1px solid #ddd;
}

th, td {
  text-align: center;
  padding: 16px;
}
tr:nth-child(even) {
  background-color: #cccccc;
}
</style>
</head>
<body>
	<%
	//jsp
	List<String> listaProdutos = new ArrayList<String>();
	for (int i = 1 ; i < 31; i++){
	listaProdutos.add("Produto" + i);
	}
	out.println("<table border=1>");
	out.println("<th>");
	out.println("Nome");
	out.println("</th>");
	out.println("<th>");
	out.println("Preco");
	out.println("</th>");
	for (String produto : listaProdutos) {
		out.println("<tr>");
		out.println("<td>");
		out.println(produto);
		out.println("</td>");
		out.println("<td>");
			int preco = (int)(Math.random() * 100);
			out.println("R$ " + preco);	
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=button value=Editar>");
		out.println("</td>");
		out.println("</tr>");
	}	
	out.println("</table>");
	%>
</body>
</html>