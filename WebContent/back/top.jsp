<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	border-bottom: solid 1px #666;
}

a {
	text-decoration: none;
	color: #000000;
}
img{
	position:fixed;
	left:0px;
	top:0px;
	height:52px;
	width:196px	
}
</style>
</head>
<body>

	<table style="width: 100%;">
		<tr>
			<td><img src="${prc }/forward/images/search_left.png"></td>
			<td style="font-family: 黑体; text-align:center; font-size: 33px; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宠物商店管理系统</td>
			<td width="25%" align="right" style="font-size: 12px;"
				valign="bottom">当前用户：
				<span style="color:red;weight:bolder;"></span>(<span style="color:red;weight:bolder;">${sessionScope.userName}</span>)&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="${prc }/userServlet?method=userLogout" target="_top">退出系统</a>
			</td>
		</tr>
	</table>
</body>
</html>