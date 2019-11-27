<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style="text-align: center;">查询学生信息</h1>
	<table class="table table-hover" border="1px" cellspacing="0px"
		width="1000px" height="200px" align="center">
		<thead>
			<tr align="center">
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生年份</th>
				<th>入学时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${stu}" var="tm">
			<tr align="center">
				<td>${tm.sid}</td>
				<td>${tm.sname}</td>
				<td>${tm.sex}</td>
				<td>${tm.birthday}</td>
				<td>${tm.grade}</td>
				<td>
					<button class="btn btn-default btn-xs btn-info"
						onClick="location.href='${pageContext.request.contextPath}/admin/editTeacher?id=${item.userid}'">修改</button>
					<button class="btn btn-default btn-xs btn-danger btn-primary"
						onClick="location.href='${pageContext.request.contextPath}/admin/removeTeacher?id=${item.userid}'">删除</button>
					<!--弹出框-->
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>