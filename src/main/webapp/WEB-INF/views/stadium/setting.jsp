<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>야구장관리</h1>
<hr />
<table>
	<tr>
		<th style="width: 200px; text-align: center">NO</th>
		<th style="width: 200px; text-align: center">구장</th>
		<th style="width: 200px; text-align: center">팀</th>
		<th style="width: 200px; text-align: center"></th>
	</tr>
	<c:forEach var="stadium" items="${stadiums}">
		<tr>
			<td style="width: 200px; text-align: center">
				${stadium.id}
			</td>
			<td style="width: 200px; text-align: center">
				${stadium.name}
			</td>
			<td style="width: 200px; text-align: center">
				${stadium.team.name}
			</td>
			<td style="width: 200px; text-align: center">
				<button class=btn-danger onclick="deleteById(${stadium.id})">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>

<script>
function deleteById(id) {
	$.ajax({
		url: "http://localhost:8080/stadium/"+id,
		method: "DELETE",
		dataType: 'json'
	}).done((res) => {
		if (res.statusCode === 1) {
			alert('삭제되었습니다.');
			location.reload();
		} else {
			alert('삭제 실패');
		}
	});
}

	
</script>

</body>
</html>