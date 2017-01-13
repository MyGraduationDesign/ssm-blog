<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客信息</title>
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
				<p>title:${blog.title }</p>
				<p>发布时间:『 <fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>』</p>
				<p>博客类别：${blog.blogType.typeName }</p>
				<p>阅读(${blog.clickHit}) 评论(${blog.replyHit})</p>
				<p>关键字：
					<c:choose>
						<c:when test="${keyWords }==null">无</c:when>
						<c:otherwise>
							<c:forEach var="keyWord" items="${keyWords }">
								${keyWord }
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</p>
				<p>内容：${blog.content }</p>
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