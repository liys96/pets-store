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
<script type="text/javascript">
<%Object result = request.getAttribute("appResult"); %>
<%if("success".equals(result)){%>
	alert("评价成功!");
<%}else if("fail".equals(result)){%>
	alert("评价失败!");
<%}%>
</script>
</head>
<body>
<!-- 网页头部 -->
		<div class="headerTop_container">
		<div class="headerTop">
			<ul class="header_topri fr">
			<c:if test="true">
				<li class="lo_no"><a href="#" id="login" rel="nofollow">欢迎你!&nbsp;&nbsp;<span style="color:red;font-size:14px">LYS</span></a></li>
				<li class="lo_no"><a href="#" id="reg" rel="nofollow">注销</a></li>
			</c:if>				
				<li class="pre_loading" style="display: none"></li>
				<li class="cart-t"><i></i><a target="_blank" href="../cart/mycart.jsp">我的购物车(<span style="color:red;font-size:13px">0</span>)</a></li>
				<li class="dropmn"><i></i>
					<p class="topgz fl">
						<a href="">我的订单</a><b></b>
					</p>
					</li>
			</ul>
		</div>
	</div>
	
	<!-- 搜索栏及logo -->
	<div class="search_containers">
		<div class="search_container">
			<div class="search_left">
				<a href="../index.jsp"><img class="top_log" src="${prc }/forward/images/search_left.png"></a>
			</div>
		</div>
	</div>
	<div class="cartde">订单评价>></div>
	<!-- 购物车详情 -->
	<table class="carttable" >		
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<th style="text-align:center" >商品名</th>
			<th style="text-align:center">数量</th>
			<th style="text-align:center">单价</th>
			<th style="text-align:center">操作</th>
		</tr>
		<c:forEach items="${list }" var="list">
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<td class="td1" >
				<img style="width:70px;height:70px;border-radius:15px" src="${prc }/downServlet?fileName=${list.commodityHeadpic}">
				<span>${list.commodityTitle }</span>
			</td>
			<td class="td3">${list.orderCommodityAmount }</td>
			<td style="text-align:center" class="singlepricce">￥${list.commodityPrice }</td>
			<td style="text-align:center" class="singleallpricce"><a style="color:red " href="javascript:openT(${list.commodityId },${list.orderId })">评价</a></td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<div class="cartBtn1">
				<a class="continueBuy1"  href="${prc }/orderServlet?method=myOrder">返回订单</a>
				<a class="buyNow1" href="${prc }/orderServlet?method=finishAppriase&orId=${orderId}">完成评价</a>
				
			</div>
	</div>
	<div class="shop_car_cuccess">
	<form name="fm1" action="${prc }/orderServlet?method=addAppriase" method="post">
		<input type="hidden" name="comId"  id = "comId"/>
		<input type="hidden" name="orId"  id = "orId"/>		
			<img  src="${prc }/forward/images/close.png" onclick="closeCofirm()">
			<p>请在输入框内输入您对本商品的评价哦~</p>
			<span><textarea style="resize:none" rows="4" cols="30" name="content"></textarea></span>
			<div class="cartBtn">
				<a class="continueBuy"  href="javascript:closeCofirm()">稍后再来</a>
				<a class="buyNow" onclick="document.fm1.submit()">立即评价</a>
				
			</div>
			</form>			
		</div>
<script type="text/javascript">
function openT(cid,oid){
	$("#comId").val(cid);
	$("#orId").val(oid);
	$(".shop_car_cuccess").css("display","block");
}
function closeCofirm(){
	$(".shop_car_cuccess").css("display","none");
}
</script>
</body>
</html>