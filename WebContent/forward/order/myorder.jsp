<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
<link href="${prc }/forward/css/myorder.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${prc }/forward/laydate/laydate.js"></script>
<link href="${prc }/forward/css/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">

var s1;
var s2;
var s3;
var s4;
 function go(num){		
	s1 = "${page.entity.serialNumber }";
	s2 = "${page.startTimeStr }";
	s3 = "${page.endTimeStr }";
	s4 = "${page.entity.orderState}";
		$("#inp").val(num);
		$("#inp1").val(s1);
		$("#startTime").val(s2);
		$("#endTime").val(s3);
		$("#inp2").val(s4);
	$("#fm").submit();
} 


function tipOpen(content,id,state) {
	$(".tipright p").text(content);
	$("#oId").val(id);
	$("#state").val(state);
	$("#tip").fadeIn(200);
}
 function toOperate(id,state) {
	window.location.href="${prc }/orderServlet?method=operateOrder&oId="+id+"&oState="+state+"&currentPage=${page.currentPage}";
} 

function tipClose() {
	$("#tip").fadeOut(200);
}
</script>
<title>我的订单</title>
</head>
<body>
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
				<a href="${prc }/forward/index.jsp"><img class="top_log"
					src="${prc }/forward/images/search_left.png"></a>
			</div>
		</div>
	</div>

	<div class="cartde">我的订单&nbsp;>></div>

	<div class="rightinfo">
		<form id = "fm" name = "fm" action="${prc }/orderServlet?method=myOrder" method="post">
		<input type="hidden" id="inp" name="currentPage" value="">
			<ul class="tools">
				<li>订单编号: <input type="text" name="serialNumber" id="inp1" value="${page.entity.serialNumber }"/>
				</li>
				<li>订购时间: <input type="text" class="laydate-icon"
					id="startTime" name="startTimeStr" value="${page.startTimeStr }"/>- <input type="text" class="laydate-icon"
					id="endTime" name="endTimeStr" value="${page.endTimeStr }"/>
				</li>
				<li>状态: <select id="inp2" name="state">
						<option value="-1">请选择</option>
						<option value="0">未发货</option>
						<option value="1">已发货</option>						
						<option value="2">待评价</option>
						<option value="4">退货中</option>
						<option value="5">已退货</option>
						<option value="6">已取消</option>
						<option value="7">已完成</option>
				</select>
				</li>
				<li class="subBut"
					onclick="document.fm.submit()">查&nbsp;询</li>
			</ul>
			<table class="tablelist">
				<thead>
					<tr>
						<th>序号</th>
						<th>订单编号</th>
						<th>总金额</th>
						<th>订购时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.list }" var="order">
					<tr>
						<td>${order.rn }</td>
						<td>${order.serialNumber }</td>
						<td>￥${order.totalMoney }</td>
						<td>${order.orderDate }</td>
						 <c:if test="${order.orderState==0 }"><td>未发货</td>
						 	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a>&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0)" class="tablelink"
							onclick="tipOpen('确定取消此订单吗？',${order.orderId},${order.orderState })">取消订单</a></td>
						 
						 </c:if>   
						 <c:if test="${order.orderState==1 }"><td>已发货</td>
						 	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a>&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0)" class="tablelink"
							onclick="tipOpen('确定此订单收货吗？',${order.orderId},${order.orderState })">确认收货</a></td>
						 
						 </c:if>
					  	 <c:if test="${order.orderState==2 }"><td>待评价</td>
					  	 	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a>&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0)" class="tablelink"
							onclick="window.location.href='${prc}/orderServlet?method=orderAppriase&orderId=${order.orderId }'">去评价					
							</a>&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0)" class="tablelink"
							onclick="tipOpen('确定退货吗？',${order.orderId},${order.orderState })">发起退货</a>
							</td>
					  	 </c:if>
					     <c:if test="${order.orderState==4 }"><td>退货中</td>
					     	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a></td>
					     </c:if>
					     <c:if test="${order.orderState==5 }"><td>已退货</td>
					     	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a></td>
					     </c:if> 
					     <c:if test="${order.orderState==6 }"><td>已取消</td>
					     	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a></td>
					     </c:if>
					      <c:if test="${order.orderState==7 }"><td>已完成</td>
					     	<td><a target="_blank" href="${prc }/orderServlet?method=myOrderView&orderId=${order.orderId}" class="tablelink">查看详情</a></td>
					     </c:if>						
					</tr>
					</c:forEach>				
				</tbody>
			</table>

		</form>
		<div class="page">		
			<div class="page_left">
				<span>当前第${page.currentPage }页,</span> <span>${page.totalCount }条数据</span>
				<span>共${page.totalPage }页</span>
			</div>
			<div class="page_right">

				<a href="#" onclick="go(${page.firstPage})" class="common_button">首页</a>

				<a href="#" onclick="go(${page.forwardPage})" class="common_button">上一页</a>


				<a href="#" onclick="go(${page.nextPage})" class="common_button">下一页</a>


				<a href="#" onclick="go(${page.lastPage})" class="common_button">尾页</a>

			</div>
		</div>


		<!-- 提示框 -->
		<input type="hidden" name="oId" id="oId">
		<input type="hidden" name="state" id="state">
		<div id="tip" class="tip">
			<div class="tiptop">
				<span>提示信息</span><a onclick="tipClose()"></a>
			</div>
			<div class="tipinfo">
				<span><img src="${prc }/back/images/ticon.png" /></span>
				<div class="tipright">
					<p></p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>
			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定"
					onclick="toOperate($('#oId').val(),$('#state').val())" /> &nbsp; <input name="" type="button"
					class="cancel" value="取消" onclick="tipClose()" />
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
<script type="text/javascript" src="${prc }/forward/js/time.js"></script>
</body>
</html>