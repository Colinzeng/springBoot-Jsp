<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" href="css/login.css" type="text/css"></link>
 <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
 <script type="text/javascript" src="js/login.js"></script>
 </head>
  
<body>
	<div id="container">
		<div id="top"></div>
        
        <div id="centry">
        <form action="adminUser/contrologin" method="post">
        	<div id="log">
            	<h3>360管理登录</h3>
                <div id="div1">
                	<input type="text" name="user" class="input" placeholder="手机号/用户名/邮箱" />
                </div>
                <div id="userMes"></div>
                <div class="div" id="div2">
                	<input type="password" name="psw" class="input" placeholder="密码" />
                </div>
                <div id="pswMes"></div>
                
                <div class="div"><input type="submit" value="登&nbsp;录"  id="input3" /></div>
                <div class="div"><span>管理员登录提示：<br/>1、请不要在公司外登录<br/>2、请不要使用浏览器记录账号密码<br/>3、严禁泄露公司内网相关信息</span></div>
            </div>
           </form>
        </div>
			
      <%@ include file="../footer.jsp" %>

</body>
</html>
