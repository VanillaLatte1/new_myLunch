<%@page import="java.util.List"%>
<%@page import="dto.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>메뉴 보기</h2>
<%
	//리스트에 Menu를 담을 수 있는 리스트에 seeServlet에서 보낸 menuList를 받는다
	List<Menu> list = (List<Menu>)request.getAttribute("menuList");		//getAttribute는 object 타입을 받기 때문에 리스트를  (List<Menu>)을 사용해 강제 형변환
	for(Menu m : list){		//list의 값을 하나씩 꺼내서 m에 담는다 / 담은 리스트의 값은 menu의 값 / getMenu로 값을 출력
		out.println(m.getMenu() + "<br>");
	}
	
%>
</body>
</html>
    