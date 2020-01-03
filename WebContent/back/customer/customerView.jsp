<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../../commons/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>客户管理</li>
    <li>客户详情</li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>客户信息</span></div>
  <ul class="forminfo">
    <li>
      <label>姓名</label>
      <cite>${customer.customerName }</cite>
    </li>
    <li>
      <label>账号</label>
      <cite>${customer.customerAccount }</cite>
    </li>
    <li>
      <label>性别</label>
      <cite>${customer.customerSex }</cite>
    </li>
    <li>
      <label>联系方式</label>
      <cite>${customer.phoneNumber }</cite>
    </li>
    <li>
      <label>收货地址</label>
      <cite>${customer.receivedAddress }</cite>
    </li>
    <li>
      <label>状态</label>
      <cite>
      <c:if test="${customer.state ==1 }">可用</c:if>
      <c:if test="${customer.state ==0 }">不可用</c:if>
      </cite>
    </li>
    <li>
      <label>注册时间</label>
      <cite>${customer.createDate }</cite>
    </li>
    <li>
      <label>&nbsp;</label>
      <input name="" type="button" class="btn" value="返回" onclick="window.history.go(-1);"/>
    </li>
  </ul>
</div>
</body>
</html>
