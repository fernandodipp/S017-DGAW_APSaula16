<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Teste
<%
/* codigo jsp */
String nome = request.getParameter("nome");
out.println("parametro nome possui valor = " + nome);
%>

</body>
</html>