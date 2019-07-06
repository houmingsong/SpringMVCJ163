<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="js/nicEdit/nicEdit.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript">
bkLib.onDomLoaded(function() {
    new nicEditor().panelInstance('area1');
});
</script>
<form action="user/release.lovo" method="post">
标题:<input type="text" name="title"><br><br>
发布类型:<select name="type">
		    <option style='display: none'></option>
            <option value ="政治">政治</option>
            <option value ="历史">历史</option>
            <option value="娱乐">娱乐</option>
            <option value="社会">社会</option>
            <option value="医疗">医疗</option>
</select><br><br>
发布内容:<textarea cols="50" id="area1" name="content"></textarea><br><br>
发布时间:<input type="date" name="typeTime"><br><br>
展示时间:<input type="date" name="displayTime"><br><br>
发布人:  <input type="text" name="publisher"><br><br>
         <input type="submit" value="发布">
</form>
</body>
</html>