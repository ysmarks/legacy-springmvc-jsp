<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista</title>
<script type="resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function finalizarAgora(id) {
			$.POST(
				"finalizaTarefa",
				{
					"id": id
				},
				function () {
					$("#finalizar_" + id).html("Finalizado");
				}
				);
		}
	</script>
	<a href="novaTarefa">Criar nova tarefa</a>
	<br/><br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizada</th>
			<th>Data finalização</th>
		</tr>
		<c:forEach var="tarefa" items="${tarefas}">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizada eq false}">
					<td id="finalizar_${tarefa.id}">
						<a href="#" onclick="finalizarAgora(${tarefa.id})">Finalizar agora</a>
					</td>
				</c:if>
				<c:if test="${tarefa.finalizada eq true}">
					<td>Finalizada</td>
				</c:if>
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="yyyy/MM/dd"/>
				</td>
				<td>
					<a href="removeTarefa?id=${tarefa.id}">Remover</a>
				</td>
				<td>
					<a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>