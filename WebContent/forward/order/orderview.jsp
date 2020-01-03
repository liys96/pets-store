<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
<link href="${prc }/forward/css/order_view_dv.css" type="text/css" rel="stylesheet">
<title>订单详情</title>
</head>
<body>
<!-- 网页头部 -->
		<!-- 网页头部 -->
	<div class="headerTop_container">
		<div class="headerTop">
			<ul class="header_topri fr">
				<c:if test="${customer !=null}">
					<li class="lo_no"><a href="#" id="login" rel="nofollow">欢迎你!&nbsp;&nbsp;<span
							style="color: red; font-size: 14px">${sessionScope.customer.customerName}</span></a></li>
					<li class="lo_no"><a href="${prc }/customerServlet?method=customerLogout" id="reg" rel="nofollow">注销</a></li>
				</c:if>
				<li class="pre_loading" style="display: none"></li>
				<li class="cart-t"><i></i><a target="_blank"
					href="${prc }/cartServlet?method=cartView">我的购物车(<span
						style="color: red; font-size: 13px">0</span>)
				</a></li>
				<li class="dropmn"><i></i>
					<p class="topgz fl">
						<a href="${prc }/orderServlet?method=myOrder">我的订单</a><b></b>
					</p></li>
			</ul>
		</div>
	</div>
	
	<!-- 搜索栏及logo -->
	<div class="search_containers">
		<div class="search_container">
			<div class="search_left">
				<a href="${prc }/forward/index.jsp"><img class="top_log" src="${prc }/forward/images/search_left.png"></a>
			</div>
		</div>
	</div>
	<div class="cartde">订单详情>></div>
	<div class="order_view_dv">
		<p>订单编号:
			<cite id="totalMoney">${order.serialNumber }</cite>
		</p>
		<p>下单时间:
			<cite id="totalMoney">${order.orderDate }</cite>
		</p>
		<p>总金额:
			<cite id="totalMoney">￥${order.totalMoney }</cite>
		</p>
		<p>订单状态:
			<cite id="totalMoney">
			<c:if
						test="${order.orderState==0 }">
								未发货
								
							</c:if> <c:if test="${order.orderState==1 }">
								已发货
								
							</c:if> <c:if test="${order.orderState==2 }">
								待评价
								
							</c:if> <c:if test="${order.orderState==4 }">
								退货中
								
							</c:if> <c:if test="${order.orderState==5 }">
								已退货
								
							</c:if>
							<c:if test="${order.orderState==7 }">
								已完成
								
							</c:if>
			
			</cite>
		</p>
		<p>收货人:
			<cite id="totalMoney">${order.customerName }</cite>
		</p>
		<p>收货人电话:
			<cite id="totalMoney">${order.customerPhoneNumber }</cite>
		</p>
		<p>收货地址:
			<cite id="totalMoney">${order.receivedAddress }</cite>
		</p>
	</div>
	<!-- 购物车详情 -->
	<table class="carttable" >		
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<th style="text-align:center" >商品名</th>
			<th style="text-align:center">数量</th>
			<th style="text-align:center">单价</th>
			<th style="text-align:center">总价</th>
		</tr>
		<c:forEach items="${list }" var="list">
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<td class="td1" >
				<img style="width:70px;height:70px;border-radius:15px" src="${prc }/downServlet?fileName=${list.commodityHeadpic}">
				<span>${list.commodityTitle }</span>
			</td>
			<td class="td3">${list.orderCommodityAmount }</td>
			<td style="text-align:center" class="singlepricce">￥${list.commodityPrice }</td>
			<td style="text-align:center" class="singleallpricce">￥${list.orderCommodityMoney }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>