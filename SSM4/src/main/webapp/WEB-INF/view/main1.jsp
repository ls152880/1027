<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">


	<div data-options="region:'north',split:true" style="height: 100px;">
	欢迎来到xxx系统
	<br>
		<a href="${pageContext.request.contextPath }/logout">退出</a>
	</div>
	<div data-options="region:'west',title:'菜单',split:true"
		style="width: 10%;">
		<ul class="easyui-tree" id="leftmenu">
			<li><span>学校管理</span>
				<ul>
					
						<li
							data-options="url:'${pageContext.request.contextPath }/user/query/studentScore'">
							<span>查看学生成绩</span>
						</li>
					

					
						<li data-options="url:'${pageContext.request.contextPath }/user/query/allTeacher'">
							<span>查看全校老师</span>
						</li>
					

				
					<li data-options="url:'${pageContext.request.contextPath }/user/add/studentScore'">
						<span>录入学生成绩</span>
					</li>
				
					
					
					<li data-options="url:'${pageContext.request.contextPath }/user/update/studentScore'">
						<span>修改学生成绩</span>
					</li>
					
					
					
					<li data-options="url:'${pageContext.request.contextPath }/user/query/classroom'">
						<span>查看教室分布</span>
					</li>
				
					
					
					<shiro:hasRole name="校长">
					<li data-options="url:'${pageContext.request.contextPath }/user/add/teacher'">
						<span>添加老师</span>
					</li>
					</shiro:hasRole>
					
				</ul>
			</li>
		</ul>
	</div>
	<div data-options="region:'center',title:'首页'"
		style="padding: 5px; background: #eee;">
		<div id="tabs" class="easyui-tabs"></div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#leftmenu").tree({
				onClick : function(node) {
					if ($("#leftmenu").tree("isLeaf", node.target)) {
						var tabs = $("#tabs");
						var tab = tabs.tabs("getTab", node.text);
						if (tab) {
							tabs.tabs("select", node.text)
						} else {
							tabs.tabs("add", {
								title : node.text,
								href : node.url,
								closable : true
							});
						}

					}
				}
			});
		});
	</script>
</body>
</html>