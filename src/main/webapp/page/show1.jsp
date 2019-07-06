<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<title>新闻详情页面</title>
</head>
<body>
	<div id="table">
		<c:forEach var="u" items="${list}">
			<table>
				<tr>
					<td>${u.title}</td>
				</tr>
				<tr>
					<td>${u.content}</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>