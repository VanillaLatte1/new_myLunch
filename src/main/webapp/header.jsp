<%@page import="dto.tbUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//세션 정보 받아오기
	tbUser dto = (tbUser)session.getAttribute("user");
	// 세션에 정보가 있으면 메뉴 입력 보이고, login => logout
	// 없으면 메뉴 입력 안 보이고, login 버튼

%>
<div class="container">
<br>
  <h1>오늘의 점심 메뉴</h1>
<br>
</div>
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <ul class="navbar-nav">
  	<li class="nav-item">
      <a class="nav-link" href="/">MAIN</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/best.menu">메뉴 추천</a>
    </li>
    <%
    	if(dto != null){
    %>
    <li class="nav-item">
      <a class="nav-link" href="/insert.menu">메뉴 입력</a>
    </li>
    <%
    }
    %>
    <li class="nav-item">
      <a class="nav-link" href="/see.menu">메뉴 보기</a>
    </li>
    <%
    	if(dto == null){
    %>
    <li class="nav-item">
      <a class="nav-link" href="/login.menu">로그인</a>
    </li>
    <%
    }
    	else{
    %>
    <li class="nav-item">
      <a class="nav-link" href="/logout.menu">로그아웃</a>
    </li>
    <%
    	}
    %>
  </ul>
</nav>