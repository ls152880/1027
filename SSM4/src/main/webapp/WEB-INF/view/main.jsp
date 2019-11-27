<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title> 
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="${pageContext.request.contextPath}/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="${pageContext.request.contextPath }/login"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav" >
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>学生管理</h2>
  <ul style="display:block">
  	<li><a href="${pageContext.request.contextPath }/teacher/query/studentall" target="right"><span class="icon-caret-right"></span>查询所有学生</a></li>
    <li><a href="${pageContext.request.contextPath }/user/query/studentScore" target="right"><span class="icon-caret-right"></span>查看学生成绩</a></li>
    <li><a href="${pageContext.request.contextPath }/user/add/studentScore" target="right"><span class="icon-caret-right"></span>添加学生</a></li>  
    <li><a href="${pageContext.request.contextPath }/user/update/studentScore" target="right"><span class="icon-caret-right"></span>修改学生成绩</a></li>   
    <li><a href="${pageContext.request.contextPath }/user/query/classroom" target="right"><span class="icon-caret-right"></span>查看教室分布</a></li>     
    
  </ul style="display:block">   
  <h2><span class="icon-user"></span>教师管理</h2>
  <ul>
   <li><a href="${pageContext.request.contextPath }/teacher/query/allTeacher" target="right"><span class="icon-caret-right"></span>查看全校老师</a></li>
   <li><a href="${pageContext.request.contextPath }/user/add/teacher" target="right"><span class="icon-caret-right"></span>添加老师</a></li>
	<li><a href="${pageContext.request.contextPath }/user/query/course" target="right"><span class="icon-caret-right"></span>查询课程</a></li>      
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="" target="blank" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath }/teacher/query/studentall" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>