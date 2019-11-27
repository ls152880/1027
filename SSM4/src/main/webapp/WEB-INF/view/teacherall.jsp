<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 style="text-align: center;">查询教师信息</h1>
	<table class="table table-hover"  border="1px" cellspacing="0px" width="700px" height="100px" align="center">
		<thead>
			<tr align="center">
				<th>教师编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生年份</th>
				<th>学历</th>
				<th>职称</th>
				<th>入职年份</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach  items="${teas}" var="tem">
			<tr align="center">
				<td>${tem.tid}</td>
					<td>${tem.tname}</td>
					<td>${tem.sex}</td>
					<td>${tem.birthday}</td>
					<td>${tem.degree}</td>
					<td>${tem.title}</td>
					<td>${tem.grade}</td>
					
					<td>
						<button class="btn btn-default btn-xs btn-info" onClick="location.href='${pageContext.request.contextPath}/admin/editTeacher?id=${item.userid}'">修改</button>
						<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='${pageContext.request.contextPath}/admin/removeTeacher?id=${item.userid}'">删除</button>
								<!--弹出框-->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>			       
</body>
</html>