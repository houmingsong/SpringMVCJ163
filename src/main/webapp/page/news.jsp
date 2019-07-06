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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻</title>
<style>
#table {
	margin-left: 800px;
}

.q{
	float: right;
	margin-top: -381px;
}
</style>
</head>
<body>
	<div>
		<a href="user/news.lovo?type=政治">政治</a><br>
		<br> <a href="user/news.lovo?type=历史">历史</a><br>
		<br> <a href="user/news.lovo?type=娱乐">娱乐</a><br>
		<br> <a href="user/news.lovo?type=社会">社会</a><br>
		<br> <a href="user/news.lovo?type=医疗">医疗</a><br>
		<br>
	</div>
	<div id="table">
		<c:forEach var="u" items="${newsList}">
			<table>
				<tr>
					<td><a href="user/getNews.lovo?newsId=${u.newsId}">${u.title}</a></td>
				</tr>
			</table>
		</c:forEach>
	</div>
	<div class="q">
		<form action="user/login.lovo" method="post">
   		 	用户:<input type="text" name="userName">
    		密码:<input type="password" name="password">
    		<input type="submit" value="登录">
		</form>
	</div>
</body>
</html>