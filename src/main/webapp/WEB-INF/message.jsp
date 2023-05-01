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
		投稿者名：<input type="text" name="name">
		メッセージ：<input type="text" name="message">
		<button>送信</button>
	</form>
	<form action="clear" method="GET">
		<button>Clear</button>
	</form>
	<hr>
	<h1>メッセージ一覧</h1>
	<br>
	<c:forEach var="mes" items="${history}">
${mes.name}:${mes.message}<br>
	</c:forEach>
</body>
</html>