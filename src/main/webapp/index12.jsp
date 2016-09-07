<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>WebSocket示例</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<form action="api/msgAction/login" method="post">
		用户名:
		<select name="id">
			<option value="1">张三</option>
			<option value="2">李四</option>
		</select><br>
		密码:
		<input name="password" type="text" value="123456">
		<input type="submit" value="登录">
		<input id="but1" type="button" value="登录1">
		<input id="but2" type="button" value="登录2">
	</form>
</body>
<script type="text/javascript">
	$("#but1").click(function(){
		$.post("api/staticTestAction/test",function(data){});
	});
	$("#but2").click(function(){
		$.post("api/staticTestAction/test1",function(data){});
	});
</script>
</html>
