<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  	
  	<div style="margin-top: 80px;" align="center">
	    <form action="adminUser/update?un=${userInfo.userName}" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td>${userInfo.userName}</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value="${userInfo.passWord}"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="cellphone" value="${userInfo.cellphone }"></td>
			</tr>
			
		    <tr>
				<td colspan="2" align="center"><input type="submit" value="修改">  <input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
	</div>
  </body>
</html>
