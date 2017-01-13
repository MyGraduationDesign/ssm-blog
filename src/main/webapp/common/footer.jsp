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
	<div id="link" style="margin:20px auto;" class="row">
		<div class="col-md-12">
		<center>
			<font style="color:red">友情链接》》</font>
			<c:forEach items="${linkList}" var="link">
				<a style="padding:5px 10px;" href="${link.linkUrl }" target="_blank">${link.linkName }</a>
			</c:forEach>
		</center>
		</div>
	</div>
	<div id="foot" class="row">
		<div class="col-md-12" >
			<div align="center" style="padding: 20px" >
				<span style="float: center;">开发于 <a  href="http://www.baidu.com" target="_blank">内师大</a></span>
				  Copyright © 2015-2016 内蒙古师范大学 版权所有
			</div>
		</div>
	</div>
</body>
</html>