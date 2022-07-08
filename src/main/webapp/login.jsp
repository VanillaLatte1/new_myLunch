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
  <h2>Log-in</h2><br>
  <form action="/login.menu" method="post">
    <div class="form-group">
      <label for="userid">ID :</label>
      <input type="text" class="form-control" id="id" placeholder="ID를 입력하세요" name="userId">
    </div>
    <div class="form-group">
      <label for="userPw">PassWord :</label>
      <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="userPw">
    </div>
    <button type="submit" class="btn btn-primary">login</button>
  </form>
</div>

</body>
</html>
    