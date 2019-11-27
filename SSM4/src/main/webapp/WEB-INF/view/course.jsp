<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>课程信息显示</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>

	<div class="col-md-10">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<h1 class="col-md-5">课程名单管理</h1>
					
					

				</div>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>课程号</th>
						<th>课程名称</th>
						
						<th>上课时间</th>
						<th>上课地点</th>
						<th>周数</th>
						<th>课程类型</th>
						<th>学分</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cou}" var="item">
						<tr>
							<td>${item.courseid}</td>
							<td>${item.coursename}</td>
							
							<td>${item.coursetime}</td>
							<td>${item.classroom}</td>
							<td>${item.courseweek}</td>
							<td>${item.coursetype}</td>
							<td>${item.score}</td>
							<td>
								<button class="btn btn-default btn-xs btn-info"
									onClick="location.href='${pageContext.request.contextPath}/admin/editCourse?id=${item.courseid}'">修改</button>
								<button class="btn btn-default btn-xs btn-danger btn-primary"
									onClick="location.href='${pageContext.request.contextPath}/admin/removeCourse?id=${item.courseid}'">删除</button>
								<!--弹出框-->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel-footer">
				<c:if test="${pagingVO != null}">
					<nav style="text-align: center">
						<ul class="pagination">
							<li><a
								href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>
							<li class="active"><a href="">${pagingVO.curentPageNo}</a></li>
							<c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
								<li><a
									href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>
							</c:if>
							<c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">
								<li><a
									href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>
							</c:if>
							<c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">
								<li><a
									href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>
							</c:if>
							<c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">
								<li><a
									href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>
							</c:if>
							<li><a
								href="${pageContext.request.contextPath}/admin/showCourse?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
		</div>

	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</body>
</html>