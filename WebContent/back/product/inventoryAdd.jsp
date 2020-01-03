<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">
<%
Object result = request.getAttribute("result");
  if("success".equals(result)){%>    
      alert("添加成功!");  
       window.location.href="${prc }/inventoryServlet?method=inventoryList"; 
<%}else if("fail".equals(result)){ %>	
		alert("添加失败,请选择商品!");
		 window.location.href="${prc }/inventoryServlet?method=searchCommodity"; 
<%}%> 
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>库存管理</li>
    <li>添加</li>
  </ul>
</div>
	
<div class="formbody">
  <div class="formtitle"><span>商品名称信息</span></div>
  <form id="fm" name="fm" action ="${prc }/inventoryServlet?method=addInventory" method="post">
  <ul class="forminfo">
    <li>
      <label  class="forminfo_li1">选择商品&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <select id="types" name="commodityId">
          <option value="-1">商品名称</option>
          <c:forEach items="${list }" var="list" >
           <option value="${list.commodityId }">${list.commodityTitle }</option>
          </c:forEach>
        </select>     
      <i>必选</i>
    </li>
    <li>
      <label>商品数量</label>
       <input name="amount" type="text" value = "100" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>&nbsp;</label>
      <input name="" type="button" class="btn" value="确定" onclick="document.fm.submit()"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="" type="button" class="btn" value="返回" onclick="window.location.href='${prc}/commodityServlet?method=commodityList'"/>
    </li>
  </ul>
  </form>
</div>
</body>
</html>
