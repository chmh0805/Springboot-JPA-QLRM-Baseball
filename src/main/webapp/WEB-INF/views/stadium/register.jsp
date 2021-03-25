<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>야구장등록</h1>
<hr />
<table>
	<tr>
		<th style="width: 200px; text-align: center">구장</th>
		<th style="width: 200px; text-align: center">팀</th>
		<th style="width: 200px; text-align: center"></th>
	</tr>
	<tr>
		<form method="POST" action="/stadium">
			<td style="width: 200px; text-align: center">
				<input type="text" name="stadiumName" />
			</td>
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