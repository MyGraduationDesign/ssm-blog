<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/user/login.do" method="post">
		用户名:<input type="text" name="userName" value="${user.userName}"/><br/><br/>
		密　码:<input type="text" name="password" value="${user.password}"/> <br/><br/>
		<input type="submit" value="登陆">
		<font color="red">${errorInfo}</font>
	</form>
</body>
</html>