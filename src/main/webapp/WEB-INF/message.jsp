<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージの累積</title>
</head>
<body>
	<form action="message" method="POST">
		投稿者名：<input type="text" name="name"> メッセージ：<input type="text"
			name="message">
		<button>送信</button>
	</form>
	<form action="clear" method="GET">
		<button>Clear</button>
	</form>
	<hr>
	<h1>メッセージ一覧</h1>
	<br>
	<c:forEach var="mes" items="${history}">
		<c:choose>
			<c:when test="${ mes.name == '京都駅前校' }">
				<c:set var="color" value="blue" />
			</c:when>
			<c:when test="${ mes.name == '洛北校' }">
				<c:set var="color" value="red" />
			</c:when>
			<c:otherwise>
				<c:set var="color" value="green" />
			</c:otherwise>
		</c:choose>
		<div style="color: ${color}">${mes.name}:${mes.message}</div>
	</c:forEach>
</body>
</html>
