<%@page import="dto.Menu"%>
<%@page import="dao.MenuDaoImpl"%>
<%@page import="dao.MenuDao"%>
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
<h2>오늘은 이거다!</h2>

<%
	MenuDao dao = new MenuDaoImpl();
	
	Menu m = dao.randomSelect();
	String menu = m.getMenu();
	int price = m.getPrice();
	String img = m.getImg();
%>
<h1>추천 메뉴 : <%=menu%></h1>
<h1>가격 : <%=price%></h1>
<img src = "<%=img%>" width = 500 height = 500>
</body>
</html>
    