<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>用户列表</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet1" href="js/bootstrap-3.3.7-dist/js/bootstrap.min.js">
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td>用户名</td>
				<td>电话</td>
				<td>操作</td>
			</tr>
			<c:forEach var="u" items="${userList }">
				<tr>
					<td>${u.userName }</td>
					<td>${u.userTel}</td>
					<td><a href="gotoUserInfo.lovo?userId=${u.userId}">查看详情</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>