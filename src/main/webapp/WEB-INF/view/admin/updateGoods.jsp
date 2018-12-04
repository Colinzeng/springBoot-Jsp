<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改商品</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div style="margin-top: 80px;" align="center">
		<form action="adminGood/update?id=${adminGood.id }" method="post">
			<table>
				<tr>
					<td>商品编号：</td>
					<td>${adminGood.id }</td>
				</tr>
				<tr>
					<td>商品名称：</td>
					<td><input type="text" name="name" value="${adminGood.name}"></td>
				</tr>
				<tr>
					<td>商品价格：</td>
					<td><input type="text" name="price" value="${adminGood.price}"></td>
				</tr>
				<tr>
					<td>商品库存：</td>
					<td><input type="text" name="stock" value="${adminGood.stock}"></td>
				</tr>
				<tr>
					<td>图片一：</td>
					<td><input type="text" name="img1" value="${adminGood.img1}"></td>
				</tr>
				<tr>
					<td>图片二：</td>
					<td><input type="text" name="img2" value="${adminGood.img2}"></td>
				</tr>
				<tr>
					<td>图片三：</td>
					<td><input type="text" name="img3" value="${adminGood.img3}"></td>
				</tr>
				<tr>
					<td>图片四：</td>
					<td><input type="text" name="img4" value="${adminGood.img4}"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="修改">
						<input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
