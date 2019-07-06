<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>添加角色</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css"
	type="text/css">
<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</head>
<body>
	<div class="q">
		<table>
			<tr>
				<td>权限：</td>
				<td>修改权限：</td>
			</tr>
			<c:forEach var="u" items="${list}">
				<tr>
					<td>${u}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>