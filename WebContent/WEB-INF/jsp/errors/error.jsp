<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../commons/base.jsp"%>
<%@ page  isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
</head>
<body>
<div style="margin:100px 600px">
<img style="width:300px;height:300px;border-radius:50%" src="${prc }/forward/images/500.jpg">
<h4>不好意思，当前会话已失效，请重新登录!!</h4><a style="color:red;font-size:20px;font-weight:bold" href="javascript:location.reload();"></a>
</div>
</body>
</html>