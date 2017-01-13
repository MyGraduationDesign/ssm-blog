<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客主页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="common/header.jsp"></jsp:include>

		<div id="blog" class="row">
			<div class="col-md-3">
				<div style="border:1px solid;margin:5px;padding:10px;">
					<h1>博主</h1>
					<div>
						<img style="width:200px;height:200ppx" src="${pageContext.request.contextPath}/static/userImages/${user.imageName}">
					</div>
					<p>用户名：${user.userName }</p>
					<p>昵称：${user.nickName }</p>
					<p>个人简介：${user.proFile }</p>
					<p>sign：${user.sign }</p>
					<p>头像：${user.imageName }</p>
				</div>
				<div style="border:1px solid;margin:5px;padding:10px;">
					<ul>
						<c:forEach items="${blogTypeCountList }" var="blogType">
							<li><a href="#">${blogType.typeName }(${blogType.blogCount })</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div id="left-blog" class="col-md-9">
				<p>${pageTitle }--${resultTotal }条记录</p>
				<c:forEach items="${blogList}" var="blog">
					<div style="border:1px solid;margin-bottom:10px;padding:10px 15px;">
						<h4 align="center">标题:<a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">${blog.title }</a></h4>
						<p align="right" style="margin-right:10px">发布日期: <fmt:formatDate value="${blog.releaseDate}" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;阅读(${blog.clickHit}) &nbsp;&nbsp;评论(${blog.replyHit})</p>
						<p>&nbsp;&nbsp;&nbsp;&nbsp;摘要: ${blog.summary }</p>
					</div>
				</c:forEach>
				<div id="bottom-blog" style="float:right">
					<ul class="pagination pagination-sm">
						${pageCode }
					</ul>
				</div>
			</div>
		</div>

		<jsp:include page="common/footer.jsp"></jsp:include>
	</div>
</body>
</html>