<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>팀등록</h1>
<hr />
<table>
	<tr>
		<th style="width: 200px; text-align: center">팀 이름</th>
		<th style="width: 200px; text-align: center"></th>
	</tr>
	<tr>
		<form method="POST" action="/team">
			<td style="width: 200px; text-align: center">
				<input type="text" name="teamName"/>
			</td>
			<td style="width: 200px; text-align: center">
				<button class="btn-success">등록</button>
			</td>
		</form>
	</tr>
</table>

</body>
</html>