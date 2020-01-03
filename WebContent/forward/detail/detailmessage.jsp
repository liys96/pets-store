<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
<link href="${prc }/forward/css/index.css" type="text/css" rel="stylesheet">
<link href="${prc }/forward/css/detailmessage.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript" src="${prc }/forward/js/jquery.XYTipsWindow.min.2.8.js"></script>
<script type="text/javascript">		

function addShopCart(){

<%
Object result = request.getSession().getAttribute("customer");
  if(result==null){%>    
      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
<%}else{ %>		
		$("#fm").submit();
<%}%> 
}
 function go(num){		
		$("#inp").val(num);
	$("#fm").submit();
} 

 function myShopCart(){

 	<%
 	Object result2 = request.getSession().getAttribute("customer");
 	  if(result2==null){%>    
 	      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
 	<%}else{ %>			
 			window.location.href="${prc}/cartServlet?method=cartView"; 
 	<%}%> 
 	}
 	
 function myOrder(){

 	<%
 	Object result3 = request.getSession().getAttribute("customer");
 	  if(result3==null){%>    
 	      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
 	<%}else{ %>	
 			
 			window.location.href="${prc }/orderServlet?method=myOrder";
 	<%}%> 
 	}
</script>
</head>
<body>
<div class="headerTop_container">
		<div class="headerTop">
			<ul class="header_topri fr">
			<c:if test="${customer ==null}">					
				<li class="lo_no"><a href="#" id="login" rel="nofollow">登录</a></li>
				<li class="lo_no"><a href="#" id="reg" rel="nofollow">注册</a></li>
			</c:if>
			<c:if test="${customer !=null}">
				<li class="lo_no"><a href="#" rel="nofollow">欢迎你!&nbsp;&nbsp;<span style="color:red;font-size:14px">${sessionScope.customer.customerName}</span></a></li>
				<li class="lo_no"><a href="${prc }/customerServlet?method=customerLogout"  rel="nofollow">注销</a></li>
			</c:if>
								
				<li class="pre_loading" style="display: none"></li>				
					<li class="cart-t"><i></i><a  href="#" onclick="myShopCart()">我的购物车(<span style="color:red;font-size:13px">${sessionScope.arr[0]}</span>)</a></li>
				<li class="dropmn"><i></i>
					<p class="topgz fl">
						<a href="#" onclick="myOrder()">我的订单</a><b></b>
					</p>
					</li>
			</ul>
		</div>
	</div>	
	
	<!-- 商品详情 -->
	<div class="deltail_content">
		<!-- 加入购物车成功提示框 -->
		<div class="shop_car_cuccess">
			<img  src="${prc }/forward/images/close.png" onclick="closeCofirm()">
			<p>恭喜成功加入购物车!</p>
			<span>购物车共有<b class="amount_Price">${arr[0] }</b>件商品，合计<b class="amount_Price">${arr[1] }</b>元</span>
			<div class="cartBtn">
				<a class="continueBuy"  href="javascript:closeCofirm()">继续购物</a>
				<a class="buyNow" href="${prc }/cartServlet?method=cartView">立即结算</a>
			</div>			
		</div>
		<div class="detail_title">
			<span class="c333 bold ft18">${commodity.commodityTitle } </span>
			<p class="c999 ft14 overflow">${commodity.commodityDescription }</p>
		</div>
		<div class="imgandpricecontainer">
			<div class="detail_left">
				<img style="width:300px;height:300px" src="${prc }/downServlet?fileName=${commodity.commodityHeadpic}"/>
			</div>
			<form id="fm" action="${prc }/cartServlet?method=addCart" method="post">
			<input type="hidden" name="cId" value="${commodity.commodityId }"/>
			<input type="hidden" name="cPrice" value="${commodity.commodityPrice }"/>
			<div class="detail_right">
				<div class="sale-prices clearfix">
    				<span class="prefix">￥</span>
    				<span class="pric">${commodity.commodityPrice }</span>
    				<div class="detail_amount">
						<span class="jinghanliang">净含量&nbsp;:&nbsp;&nbsp;${commodity.commodityQuantity }kg</span><br>
						<span class="kucun">剩余库存&nbsp;:&nbsp;&nbsp;<span>${commodity.inventoryAmount }</span>&nbsp;${commodity.commodityUnit }</span>
						<span class="shuliang">数量&nbsp;:</span>&nbsp;&nbsp;
						<span class="amount_container">
						<span class="jishu" id="jian"  onclick="jianshu()">－</span> 
						<input type="text" onblur="checkInv()" name="cAmount" class="amount_in" id="detailAmount" value="1">
						<input type="hidden" id="unit" value="${commodity.commodityUnit }"/>
						<span class="jishu" id="jia" onclick="jiashu()">＋</span>						
						</span>
					</div>
				</div>
				<div class="shopcar">
					<a href="javascript:addShopCart()" class="epet_sensor_add_cart">加入购物车</a>
				</div>
			</div>
			</form>
		</div>
	</div>
	<!-- 评价 -->
	<form id = "fm" name="fm" action="${prc }/productServlet?method=searchCommodityInfo&cId=${commodity.commodityId}" method="post">
	<input id="inp" type="hidden" name="currentPage" value="" />
	<div class="appraise_container">
		<span class="appraise_container_descrip">
			商品评价&nbsp;:
		</span>
			<c:forEach items="${page.list }" var="list">
		<div class="appraisal">
			<div class="appraisal_left">
				<div>
					<img src="${prc }/downServlet?fileName=${list.customerPic}">
				</div>
				<span>${list.customerName }</span>
			</div>
			<div class="appraisal_right">
				<div class="right_content">
					<span>
					${list.appraiseContent }
					</span>
				</div>
				<div class="timeandfloor">
					<span>${list.rn }</span>楼 &nbsp; &nbsp; &nbsp;<span>${list.appraiseDate }</span>
				</div>
			</div>
		</div>		
		</c:forEach>
		<div class="page">
					<div class="page_left">
						<span>当前第${page.currentPage }页,</span>
						<span>${page.totalCount }条数据</span>
						<span>共${page.totalPage }页</span>					
					</div>
					<div class="page_right">
						
							<a href="#" onclick="go(${page.firstPage})" class="common_button" >首页</a>
						
							<a href="#" onclick="go(${page.forwardPage})"  class="common_button" >上一页</a>
						
						
							<a href="#" onclick="go(${page.nextPage})" class="common_button" >下一页</a>
						
						
							<a href="#" onclick="go(${page.lastPage})" class="common_button" >尾页</a>
						
					</div>
				</div>
	</div>
	</form>
		
</body>
<script type="text/javascript">
<%
Object result1 = request.getAttribute("cartResult");
  if("success".equals(result1)){%>  
  $(".shop_car_cuccess").css("display","block");      
<%}%>
//添加购物车
/* function addSuccess(){
	$(".shop_car_cuccess").css("display","block");
} */
function closeCofirm(){
	$(".shop_car_cuccess").css("display","none");
}
function jianshu(){
	var amount = $("#detailAmount").val()-1;
	if(amount>=1){
		$("#detailAmount").val(amount);
	}else if(amount<=0){
	$("#detailAmount").val(1);
	alert("请至少选择一"+$("#unit").val()+"哦!");
}

}
var inv;
function jiashu(){
inv = ${commodity.inventoryAmount};
$("#detailAmount").val();
var amount = Number($("#detailAmount").val())+1;
$("#detailAmount").val(amount);
if($("#detailAmount").val()>=inv){
	var c = $("#unit").val();
	alert("库存不够了!!最多只能购买"+inv+c);
	$("#detailAmount").val(inv);
}
}
//鼠标离开输入框判断库存是否足够
var inv1;
function checkInv(){
	inv1 = ${commodity.inventoryAmount};
if($("#detailAmount").val()>=inv1){
	var c = $("#unit").val();
	alert("库存不够了!!最多只能购买"+inv1+c);
	$("#detailAmount").val(inv1);
}
}

$(document).ready(function() {
	
	$("#login").click(function(){
		$.XYTipsWindow({
			___title:"登录",
			___content:"iframe:${prc}/forward/login.jsp",
			___width:"460",
			___height:"150",
			___showbg:true,
			___drag:"___boxTitle"

		});
	});
	
	$("#reg").click(function(){
		$.XYTipsWindow({
			___title:"注册",
			___content:"iframe:${prc}/forward/reg.jsp",
			___width:"460",
			___height:"400",
			___showbg:true,
			___drag:"___boxTitle"
		});
	});
	


 })

</script>
</html>