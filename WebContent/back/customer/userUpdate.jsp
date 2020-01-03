<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<%
Object result = request.getAttribute("success");
  if("success".equals(result)){ %>    
      alert("修改成功!");  
      window.location.href="${prc }/userServlet?method=userList";
<%}else if("fail".equals(result)){ %>	
		alert("添加失败!");
<%}%> 

</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="userList.html">系统管理</a></li>
    <li><a href="userList.html">用户管理</a></li>
    <li><a href="#">修改</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>员工信息</span></div>
  <form action="${prc }/userServlet?method=updateUser&userId=${user.userId}" method="post" id="fm" name="fm">
  <ul class="forminfo">
    <li>
      <label>账号</label>
      <input name="userAccount" type="text" value="${user.userAccount }" class="dfinput" readonly="readonly"/>
      <i>只读,不可更改</i>
    </li>
    <li>
      <label>密码</label>
      <input name="userPassword" type="password" value="${user.userPassword }" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>名称</label>
      <input name="userName" type="text" value="${user.userName }" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>状态</label>
      <select name="state" class="dfselect">
        <option value="1" selected="selected">可用</option>
        <option value="0">不可用</option>
      </select>
    </li>
    <li>
      <label>&nbsp;</label>
      <input name="" type="button" class="btn" onclick="document.fm.submit()" value="确认保存"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="" type="button" class="btn" value="返回"  onclick="window.history.go(-1);"/>
    </li>
  </ul>
  </form>
</div>
</body>
</html>
