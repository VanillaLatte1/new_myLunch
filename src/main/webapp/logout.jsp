<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 세션 정보 모두 삭제
	session.invalidate();
%>
<script>
	alert("로그아웃 되었습니다.")
	location.href = "/";
</script>
</body>
</html>