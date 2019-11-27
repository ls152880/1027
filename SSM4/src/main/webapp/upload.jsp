<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/file/upload" method="post" enctype="multipart/form-data">
		选择文件:<input type="file" name="file" width="120px">
		<input type="submit" value="上传">
	</form>
	<hr>
	<a href="${pageContext.request.contextPath }/file/download?filename=IO总结.docx">IO总结.docx</a>
</body>
</html>