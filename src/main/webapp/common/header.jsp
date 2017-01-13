<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-md-6">
			<span style="margin:20px;font-size:28px;padding:15px;color:red">个人博客系统</span>
		</div>
	</div>
	<div id="menu" class="row">
			<div class="col-md-12" style="padding-top: 10px">
				<ul class="nav nav-pills">
		        	<li class="active"><a href="index.html">Home</a></li>
		            <li><a href="${pageContext.request.contextPath}/login.jsp">登陆</a></li>
		            <li style="float:right">
		            	<form action="${pageContext.request.contextPath}/blog/q.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
					        <div class="form-group" >
					          <input type="text" id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字...">
					        </div>
					        <button type="submit" class="btn btn-default">搜索</button>
					      </form>
		            </li>
		        </ul>
			</div>
		</div>
</body>
</html>