<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostra</title>
</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="POST">
		<input type="hidden" name="id" value="${tarefa.id}">
		
		Descição: <br/>
		<textarea rows="5" cols="1000" name="descricao">
			${tarefa.descricao}
		</textarea>
		<br/>
		Finalizado? <input type="checkbox" name="finalizada" value="true"
			${tarefa.finalizada? 'checked' : '' }><br/>
		
		Data finalização: <br/>
		<input type="text" name="dataFinalizacao" value='<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="yyyy/MM/dd"/>'>
		
		<input type="submit" value="Alterar">
	</form>
</body>
</html>