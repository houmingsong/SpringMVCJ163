<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>修改新闻类型</title>
</head>
<body>
<form action="user/update.lovo?newsId=<%=request.getParameter("newsId")%>" method="post">
选择需要修改的类型:<select name="type">
			   <option  style='display: none'></option>
			   <option value="政治">政治</option>
			   <option value="历史">历史</option>
			   <option value="娱乐">娱乐</option>
			   <option value="社会">社会</option>
			   <option value="医疗">医疗</option>
			   </select>
			   <input type="submit" value="修改">
			   </form>
</body>
</html>