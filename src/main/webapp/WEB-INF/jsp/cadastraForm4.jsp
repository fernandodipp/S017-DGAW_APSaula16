<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.aula.Preco,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<%
	String nome = request.getParameter("nome");
		String preco = request.getParameter("preco");

		Preco produto = new Preco();
		produto.nome = nome;
		produto.preco = Float.parseFloat(preco);
		/*chama lista de produto*/
		ArrayList<Preco> listaProdutos = (ArrayList<Preco>) application.getAttribute("lista_produtos");
		/*caso a lista nao exista, o programa cria uma*/
		if(listaProdutos == null) 
		{ArrayList<Preco> lista = new ArrayList<Preco>();}
		
		listaProdutos.add(produto);

		application.setAttribute("lista_produtos", listaProdutos);

		for (preco p : listaProdutos) {
			out.println("Nome Produto: " + p.nome);
			out.println("<br>");
			out.println("Nome Produto: " + p.preco);
			out.println("<br>");
			out.println("<br>");

		}

		/* 	out.println("nome: " + nome);
			out.println("<br>");
			out.println("preco: " + preco); */
	%>
</body>
</html>