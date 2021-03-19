<html>
<body>
	<div class="container">
		Bem vindo, ${name}, à página JSP!! <br>

		<%
		out.println("<i>Código gerado por jsp.</i>");
		out.println("meu nome é Fernando");
		%>
		<!-- aqui já é html -->
		<br>
		<%
		String nome = "Maria da Siva";
		int idade = 50;
		if (idade > 18) {
			out.println(nome + " é maior de idade");
		} else {
			out.println(nome + " é menor de idade");
		}

		for (int i = 0; i < 5; i++) {
			out.println("<br>valor do contador = " + i);
		}
		%>
		<br> <br> <br> <a href="produtos">Produtos</a>
	</div>


</body>
</html>