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
<div class="container">
  <h2>메뉴 입력</h2><br>
  <form action="/action_page.php">
    <div class="form-group">
      <label for="menu">메뉴 :</label>
      <input type="text" class="form-control" id="menu" placeholder="메뉴를 입력하세요" name="menu">
    </div>
    <div class="form-group">
      <label for="price">가격 :</label>
      <input type="number" class="form-control" id="price" placeholder="가격을 입력하세요" name="price">
    </div>
    <div class="form-group">
      <label for="price">이미지 주소 :</label>
        <input type="text" class="form-control" id="img" placeholder="이미지 주소를 입력하세요" name="img">
    </div><br>
    <button type="submit" class="btn btn-primary">입력</button>
  </form>
</div>

</body>
</html>
    