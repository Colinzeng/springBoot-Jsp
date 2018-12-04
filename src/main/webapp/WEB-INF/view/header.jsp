<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
  <link rel="stylesheet" href="css/1.css" type="text/css"></link>
  
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  
  <script type="text/javascript" src="js/header.js"></script>
  </head>
  
  <body>
     <c:if test="${empty username}">
 	 <script type="text/javascript">
	$(document).ready(function () {
		$("#span4").hide();
	
	});
 </script>
 </c:if>
 <c:if test="${!empty username}">
 <script type="text/javascript">
	$(document).ready(function () {
		$("#span3").hide();
	});
	var error = '${error}';
	if(error != '')
		alert(error);
	
	var success = '${success}';
	if(success != '')
		alert(success);
 </script>
  </c:if>
  <div style="width: 100%">
  
	<div id="top"  >
		<span id="span1" style="margin-left: 450px;" >
			<a href="/">360官网</a>|<a href="/">360社区</a>
		</span>
		<span id="span2" style="margin-right: 450px;">
			<span id="span3"><a href="login">登录</a> | <a href="register">注册</a></span>
			<span id="span4">欢迎登录！${username}|<a href="userInfo/exit">退出</a></span>
			| <a href="cart/list">我的购物车</a>
		</span>
    </div>
    
  <div id="banner">
  	  <img style="margin-left: -110px;" src="img/logo1.png" />
	  <form action="good/fuzzy" method="post">
		  <span style="margin-right: 450px;" >
		  	<input type="text" name="goods" id="input1" value="360手机"/>
		  	<input type="submit" value="搜索" id="input2" />
		  </span>
	  </form>
  </div>
  
  <div id="menu">
    <ul>
     <li><a href="/">首页</a></li>
     <li><a href="/">手机</a>
     	 <div class="div" id="div1">
         	<div>
         		<a href="good/det?id=10101"><img src="img/phone/1.jpg" /></a>
         		<p style="text-align: center;">360手机 vizza</p>
         		<p style="text-align: center;color: red;">799.00</p>
         	</div>
            <div>
            	<a href="good/det?id=10105"><img src="img/phone/2.jpg" /></a>
            	<p style="text-align: center;">360手机 N5 全网通</p>
         		<p style="text-align: center;color: red;">1299.00</p>
            </div>
            <div>
            	<a href="/"><img src="img/phone/3.jpg" /></a>
            	<p style="text-align: center;">360手机 N5S 全网通</p>
         		<p style="text-align: center;color: red;">1699.00</p>
            </div>
            <div>
            	<a href="/"><img src="img/phone/4.jpg" /></a>
           		<p style="text-align: center;">360手机 F5 移动高配版</p>
        		<p style="text-align: center;color: red;">499.00</p>
            </div>  
         </div>  
     </li>
     <li><a href="/">行车记录仪</a>
     	 <div class="div" id="div2">
     	 	<div>
            	<a href="good/det?id=10104"><img src="img/tachograph/1.jpg" /></a>
           		<p style="text-align: center;">M302 高清夜视 前后双录</p>
        		<p style="text-align: center;color: red;">339.00</p>
            </div>
            <div>
            	<a href="good/det?id=10104"><img src="img/tachograph/2.jpg" /></a>
           		<p style="text-align: center;">二代 美猴王版</p>
        		<p style="text-align: center;color: red;">529.00</p>
            </div>
            <div>
            	<a href="good/det?id=10104"><img src="img/tachograph/3.jpg" /></a>
           		<p style="text-align: center;">二代 美猴王版</p>
        		<p style="text-align: center;color: red;">499.00</p>
            </div>
            <div>
            	<a href="good/det?id=10104"><img src="img/tachograph/4.jpg" /></a>
           		<p style="text-align: center;">360行车记录仪尊享升级版</p>
        		<p style="text-align: center;color: red;">339.00</p>
            </div>
         </div>  
     </li>
     <li><a href="/">其他产品</a>
     	<div class="div" id="div3">
         	<div>
         		<a href="/"><img src="img/other/1.jpg" /></a>
         		<p style="text-align: center;">360 智能摄像机 云台版</p>
        		<p style="text-align: center;color: red;">299.00</p>
         	</div>
            <div>
            	<a href="/"><img src="img/other/2.jpg" /></a>
            	<p style="text-align: center;">360安全路由器P3</p>
        		<p style="text-align: center;color: red;">199.00</p>
            </div>
            <div>
            	<a href="/"><img src="img/other/3.jpg" /></a>
            	<p style="text-align: center;">360智能摄像机悬浮</p>
        		<p style="text-align: center;color: red;">259.00</p>
            </div>
            <div>
            	<a href="/"><img src="img/other/4.jpg" /></a>
            	<p style="text-align: center;">360安全路由器P1 天际蓝</p>
        		<p style="text-align: center;color: red;">99.00</p>
            </div>
         </div>  
     </li>
     <li><a href="/">二手手机</a></li>
     <li><a href="/">社区</a></li>
     <li><a href="/">游戏中心</a></li>
    </ul>
  </div>
  </div>
  </body>
</html>
