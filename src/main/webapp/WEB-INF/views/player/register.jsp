<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>선수등록</h1>
<hr />
<table>
	<tr>
		<th style="width: 200px; text-align: center">팀</th>
		<th style="width: 200px; text-align: center">포지션</th>
		<th style="width: 200px; text-align: center">이름</th>
		<th style="width: 200px; text-align: center"></th>
	</tr>
	<tr>
		<form method="POST" action="/player">
			<td style="width: 200px; text-align: center">
				<input type="text" name="teamName" />
			</td>
			<td style="width: 200px; text-align: center">
				<input type="text" name="position"/>
			</td>
			<td style="width: 200px; text-align: center">
				<input type="text" name="playerName"/>
			</td>
			<td style="width: 200px; text-align: center">
				<button class="btn-success">등록</button>
			</td>
		</form>
	</tr>
</table>

</body>
</html>