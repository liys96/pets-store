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
Object result = request.getAttribute("result");
  if("success".equals(result)){%>    
      alert("修改成功!");  
      window.location.href="${prc }/commodityServlet?method=commodityList";
<%}else if("fail".equals(result)){ %>	
		alert("修改失败!");
<%}%> 
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>采购管理</li>
    <li>商品管理</li>
    <li>修改</li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>商品信息</span></div>
  <form id="fm" name="fm" action ="${prc }/commodityServlet?method=updateCommodity" enctype="multipart/form-data" method="post">
  <input type ="hidden" value="${commodity.commodityId }" name="cId"/>
  <ul class="forminfo">
    <li>
      <label>商品名称</label>
      <input name="title" type="text" value="${commodity.commodityTitle }" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>商品图片</label>
      <input name="headPic" type="file" />
    </li>
    <li>
      <label>商品单价</label>
      <input name="price" type="text" value="${commodity.commodityPrice }" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>商品描述</label>
      <input name="description" type="text" value="${commodity.commodityDescription }" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>状态</label>
      <select class="dfselect" name="state">
          <option value="1">可用</option>
          <option value="0">不可用</option>
        </select>
      <i>必选</i>
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
