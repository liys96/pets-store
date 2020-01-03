<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">
<%
Object result = request.getAttribute("success");
  if("success".equals(result)){%>    
      alert("添加成功!");  
      window.location.href="${prc }/userServlet?method=userList";
<%}else if("fail".equals(result)){ %>	
		alert("添加失败!");
<%}%> 

function addUser(){
	$("#fm").submit();
}
</script>
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">系统管理</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">添加</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>员工信息</span></div>
  <form action ="${prc }/userServlet?method=addUser" method="post" id="fm" name="fm">
  <ul class="forminfo">
    <li>
      <label>账号</label>
      <input type="text" class="dfinput" name="userAccount"/>
      <i>必填</i>
    </li>
        <li>
      <label>密码</label>
      <input type="password" class="dfinput" name="userPassword"/>
      <i>必填</i>
    </li>
    <li>
      <label>名称</label>
      <input type="text" class="dfinput" name="userName"/>
      <i>必填</i>
    </li>
    <li>
      <label>&nbsp;</label>
      <input  type="button" class="btn" onclick="addUser()" value="确认保存"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input  type="button" class="btn" value="返回"  onclick="window.history.go(-1);"/>
    </li>
  </ul>
  </form>
</div>
</body>
</html>
