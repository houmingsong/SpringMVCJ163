<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>springMVC</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String imgpath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
</head>
<body>
	<div align="center">
		<ul>
			<c:forEach var="u" items="${userList}">
           用户名:<span>${u.userName }</span><br>
           手机:<span>${u.userTel }</span><br>
          照片：:<img src="<%=imgpath%>img/${u.imgPath }"
					style="width: 200px; height: 250px" />
			</c:forEach>
		</ul>
	</div>
</body>
</html>