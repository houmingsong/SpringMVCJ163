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
<title>backstage</title>
<style>
#find {
	text-align: center;
}

#table {
	text-align: center;
}
</style>
</head>
<body>

	<div id="find">
		<form action="user/backstage.lovo" method="post">
		发布时间:<input type="date" name="startDate"> 
			   <input type="date" name="endDate"> 
		新闻类型:<select name="type">
			   <option style='display: none'></option>
			   <option value="政治">政治</option>
			   <option value="历史">历史</option>
			   <option value="娱乐">娱乐</option>
			   <option value="社会">社会</option>
			   <option value="医疗">医疗</option>
			   </select>
		新闻标题:<input type="text" name="title"> 
		<input type="submit" value="查询">
		</form>
	</div>
	<br>
	<br>
	<div>
	<c:forEach var="u" items="${list}">
		<table align="center">
			<tr>
				<td><a href="user/getNews.lovo?newsId=${u.newsId}">${u.title}</a></td>
				<td><a href="page/update.jsp?newsId=${u.newsId}">修改</a></td>
			</tr>			
		</table>
		</c:forEach>
	</div>
	<div>
		<a href="page/aaa.jsp">发布新闻</a><br>
		<br><a href="user/AllUser.lovo">用户管理</a><br> <br>
	</div>
</body>
</html>