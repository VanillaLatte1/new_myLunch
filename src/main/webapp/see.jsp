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
<br>
<h2>추천 메뉴 리스트</h2><br>

<table class="table table-hover">
    <thead>
      <tr>
        <th>메뉴</th>
        <th>가격</th>
        <th>이미지</th>
        <th>수정</th>
        <th>삭제</th>
      </tr>
    </thead>
<%
	//리스트에 Menu를 담을 수 있는 리스트에 seeServlet에서 보낸 menuList를 받는다
	List<Menu> list = (List<Menu>)request.getAttribute("menuList");		//getAttribute는 object 타입을 받기 때문에 리스트를  (List<Menu>)을 사용해 강제 형변환
	for(Menu m : list){		//list의 값을 하나씩 꺼내서 m에 담는다 / 담은 리스트의 값은 menu의 값 / getMenu로 값을 출력
		int id = m.getId();
		String menu = m.getMenu();
		int price = m.getPrice();
		String img = m.getImg();
%>
		
	<tbody>
      <tr>
        <td><%=menu%></td>
        <td><%=price%></td>
        <td><img src = "<%=img%>" width = 50 height = 50></td>
        <td><a href="menuMod.jsp?id=<%=id%>&menu=<%=menu%>&price=<%=price%>">수정</a></td>
        <td><a href="menuDel.jsp?id=<%=id%>&menu=<%=menu%>">삭제</a></td>
<%
	}
%>  
		</tr>
	</tbody>
</table>  
      
</body>
</html>
    