<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
<link href="${prc }/forward/css/detailmessage.css" type="text/css" rel="stylesheet">
<link href="${prc }/forward/css/cart.css" type="text/css" rel="stylesheet">
<title>我的购物车</title>
<script type="text/javascript">
function myShopCart(){

	<%
	Object result1 = request.getSession().getAttribute("customer");
	  if(result1==null){%>    
	      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
	<%}else{ %>			
			window.location.href="${prc}/orderServlet?method=myOrder"; 
	<%}%> 
	}

<%
Object result = request.getAttribute("checkResult");
  if("success".equals(result)){%>    
      alert("下单成功!");
      window.location.href="${prc}/cartServlet?method=addcOrder";
<%}else if("fail".equals(result)){ %>		
	  alert("支付密码错误!请重新输入!!");     
<%}%>
</script>
</head>
<body>
	<!-- 网页头部 -->
		<div class="headerTop_container">
		<div class="headerTop">
			<ul class="header_topri fr">
			<c:if test="${customer ==null}">					
				<li class="lo_no"><a href="#" id="login" rel="nofollow">登录</a></li>
				<li class="lo_no"><a href="#" id="reg" rel="nofollow">注册</a></li>
			</c:if>
			<c:if test="${customer !=null}">
				<li class="lo_no"><a href="#" id="login" rel="nofollow">欢迎你!&nbsp;&nbsp;<span style="color:red;font-size:14px">${sessionScope.customer.customerName}</span></a></li>
				<li class="lo_no"><a href="${prc }/customerServlet?method=customerLogout" id="reg" rel="nofollow">注销</a></li>
			</c:if>
				
				
				
				<li class="pre_loading" style="display: none"></li>
					<li class="cart-t"><i></i><a  href="#" onclick="myShopCart()">我的购物车(<span style="color:red;font-size:13px">${sessionScope.arr[0]}</span>)</a></li>
				<li class="dropmn"><i></i>
					<p class="topgz fl">
						<a href="#" onclick="myShopCart()">我的订单</a><b></b>
					</p>
					</li>
			</ul>
		</div>
	</div>
	<form id ="fm1" name ="fm1" action="${prc }/cartServlet?method=checkPay" method="post">
			<div class="shop_car_cuccess">
			<img  src="${prc }/forward/images/close.png" onclick="closeCofirm()">
			<p>请输入您的支付密码确认下单!</p>
			<span><input style="width:250px;height:30px;border:1px solid red" type="password" name="pWord"/></span>
			<div class="cartBtn">
				<a class="continueBuy"  href="javascript:closeCofirm()">考虑一下</a>
				<a class="buyNow" onclick="document.fm1.submit()">立即下单</a>
				
			</div>			
		</div>
		</form>
	<!-- 搜索栏及logo -->
	<div class="search_containers">
		<div class="search_container">
			<div class="search_left">
				<a href="${prc }/forward/index.jsp"><img class="top_log" src="${prc }/forward/images/search_left.png"></a>
			</div>
		</div>
	</div>
	<div class="cartde">购物车详情>></div>
	<!-- 购物车详情 -->
	<table id="tb" class="carttable" >
		<c:if test="${!empty list}">
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<th style="text-align:center" >商品名</th>
			<th style="text-align:center">数量</th>
			<th style="text-align:center">单价</th>
			<th style="text-align:center">总价</th>
			<th style="text-align:center">操作</th>
		</tr>
		<c:forEach items="${list }" var="commodity">
		<tr class="carttable_tr" style="border:1px solid #ccc">
			<td class="td1" >
				<img src="${prc }/downServlet?fileName=${commodity.commodityHeadPic}">
				<span>${commodity.commodityTitle }</span>
			</td>
			<td class="td3">${commodity.commodityAmount}</td>
			<td style="text-align:center" class="singlepricce">￥${commodity.commodityPrice }</td>
			<td style="text-align:center" class="singleallpricce">￥${commodity.commodityMoney}</td>
			<td style="text-align:center"><a href="${prc }/cartServlet?method=deleteCart&cartId=${commodity.shopcartId}" class="deleteA">删除</a></td>
		</tr>
		</c:forEach>
		<tr >
			<td colspan="4" class="jiesuan" style="border:1px solid #ccc">
				<div class="clear"><a href="${prc }/cartServlet?method=clearCart" class="deleteA">清空购物车</a></div>
				<div class="zongjia">总金额&nbsp;:<a>&nbsp;￥${sessionScope.arr[1] }</a></div>
				<div class="shopcar">					
					<a href="#" onclick="showF()" class="epet_sensor_add_cart">去结算</a>
				</div>
			</td>
		</tr>
		</c:if>
		<c:if test="${empty list}">
		<tr class="carttable_tr" style="border:1px solid #ccc;">
			<td style="text-align:center;font-size:20px">你的购物车空空如也哦,赶紧去选购吧!&nbsp;&nbsp;<a style="color:red" href="${prc }/forward/index.jsp">去主页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;<a style="color:gray" href="${prc }/orderServlet?method=myOrder">我的订单</a>
			</td>
		</tr>
		</c:if>
	</table>
	<script type="text/javascript">	
	function showF(){
		$(".shop_car_cuccess").css("display","block");
	}
	function closeCofirm(){
		$(".shop_car_cuccess").css("display","none");
	}
	</script>
</body>
</html>