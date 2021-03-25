<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>선수관리</h1>
<hr />
<table>
	<tr>
		<th style="width: 200px; text-align: center">포지션</th>
		<th style="width: 200px; text-align: center">롯데자이언츠</th>
		<th style="width: 200px; text-align: center">삼성라이언즈</th>
		<th style="width: 200px; text-align: center">KT Wiz</th>
	</tr>
	<c:forEach var="player" items="${players}">
		<tr>
			<td style="width: 200px; text-align: center">
				${player.position}
			</td>
			<td style="width: 200px; text-align: center">
				${player.lotte}
			</td>
			<td style="width: 200px; text-align: center">
				${player.samsung}
			</td>
			<td style="width: 200px; text-align: center">
				${player.kt}
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>