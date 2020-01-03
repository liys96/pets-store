<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>左边菜单</title>
<link href="${prc }/back/css/style-1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>
</head>
<body style="background:#FFFADD;">
	<div class="lefttop">
		<span></span>
	</div>
	<dl class="leftmenu">
		
		<dd>
			<div class="title">
				<span><img src="${prc }/back/images/icon.png" /></span>用户管理
			</div>
			<ul class="menuson">
				<li><cite></cite> <a href="${prc }/customerServlet?method=customerList"
					target="rightFrame">客户管理</a></li>
				<li><cite></cite> <a
					href="${prc }/userServlet?method=userList" target="rightFrame">用户管理</a>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${prc }/back/images/icon.png" /></span>商品管理	
			</div>
			<ul class="menuson">
				<li><cite></cite> <a href="${prc }/commodityServlet?method=commodityList"
					target="rightFrame">商品管理</a></li>
				<li><cite></cite> <a href="${prc }/inventoryServlet?method=inventoryList"
					target="rightFrame">库存管理</a></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${prc }/back/images/icon.png" /></span>订单管理	
			</div>
			<ul class="menuson">
				<li><cite></cite> <a href="${prc }/orderServlet?method=orderList"
					target="rightFrame">订单管理</a></li>
			</ul>
		</dd>
	</dl>
</body>
</html>