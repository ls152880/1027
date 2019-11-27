<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/hello/testPerson" method="post">
		账号：<input type="text" name="pid"/>
		<br>
		名字:<input type="text" name="pname">
		<br> 
		生日:<input type="Date" name="birthday">
		<br> 
		<input type="submit">
	</form>
</body>
</html>