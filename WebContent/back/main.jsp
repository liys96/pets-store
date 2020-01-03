<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
 <%  Object user = request.getSession().getAttribute("userName");%>
 
 <%if("".equals(user)||user == null){%>
 	alert("你没有登录或session已失效!!请先登录!!");
 	window.location.href = "login.jsp";
 <%}%>
</script>
<title>宠物商店管理系统</title>
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
</head>
<frameset rows="88,*,60" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="${prc }/back/top.jsp" name="topFrame" scrolling="No" noresize="noresize"
		id="topFrame" title="topFrame" />
	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="${prc }/back/left.jsp" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="${prc }/customerServlet?method=customerList" name="rightFrame"
			id="rightFrame" title="rightFrame" />
	</frameset>
	<frame src="${prc }/back/footer.jsp" name="footerFrame" scrolling="No"
		noresize="noresize" id="footerFrame" title="footerFrame" />
</frameset>
<noframes>
</noframes>
</html>