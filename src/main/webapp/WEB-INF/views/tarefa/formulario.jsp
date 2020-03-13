<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Adiciona tarefa</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="POST">
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<input type="submit" value="adiciona" />
	</form>
</body>
</html>