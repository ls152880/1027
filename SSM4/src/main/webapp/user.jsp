<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
</head>
<body>
	<button id="btn" type="button">testUser</button>
</body>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/user/findUserByPage",
				dataType:"json",
				success:function(data){
					console.log(data);
				}
			})
		});
	});
</script>
</html>