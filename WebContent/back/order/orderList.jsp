<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文本</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<style type="text/css">
* {
	margin: 0;
	text-decoration: none;
	list-style: none;
}

/*page*/
.page {
	position: absolute;
	right: 178px;
	bottom: 0px;
	width: 582px;
	height: 38px;
}

.page_right {
	position: absolute;
	width: 345px;
	height: 38px;
	right: 62px;
	bottom: 210px;
}

.common_button {
	display: block;
	margin-left: 11px;
	width: 66px;
	height: 29px;
	float: left;
	color: #444444;
	text-align: center;
	line-height: 29px;
	background-color: #ddd;
}

.common_button:hover {
	background-color: lightgray;
	outline: 2px solid gray;
}

.page_left {
	position: absolute;
	bottom: 210px;
	right: 400px;
	width: 266px;
	height: 28px;
}

.page_left span {
	color: #444444;
	font-size: 14px;
	font-family: "微软雅黑";
	margin-right: 15px;
	float: left;
}
/* 排序条件 */
.condition_a {
	display: block;
	width: 66px;
	height: 60px;
	color: gray;
	text-align: center;
	line-height: 60px;
	font-size: 13px;
	float: left;
	border-right: 2px solid #ddd;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
}

.condi_a1 {
	border-left: 2px solid #ddd;
}

.condi_a2 {
	background: url(../images/paixu-ico.png) no-repeat 38px 7px;
}

.condi_a2:hover {
	background: url(../images/paixu-ico.png) no-repeat -26px 7px;
}

.condition_a:hover {
	color: white;
	background-color: #617899;
	border-right: 2px solid #617899;
}

.contai_imgandtitle {
	position: relative;
	margin: 10px auto;
	width: 170px;
	height: 170px;
	color: gray;
}

.detail_sailprice a {
	color: #4d4d4d;
	font-size: 14px;
}

.detail_sailprice a:hover {
	color: #248dcc;
}

.contai_imgandtitle img {
	width: 170px;
	height: 170px;
}

.detail_sailprice {
	position: relative;
	margin: 0px auto;
	width: 200px;
	height: 115px;
}

.price {
	display: block;
	margin: 10px auto;
	margin-top: 10px !important;
	color: #FF6600;
	font-size: 20px;
	text-align: center;
}

.shouchu {
	display: block;
	margin: 14px auto;
	margin-top: 3px !important;
	text-align: center;
	color: gray;
	font-size: 15px;
}
</style>
<script type="text/javascript">

var s1;
var s2;
 function go(num){		
	s1 = "${page.entity.serialNumber }";
	s2 = "${page.entity.orderState }";
		$("#inp").val(num);
		$("#inp1").val(s1);
		$("#inp2").val(s2);
	$("#fm").submit();
} 
 function tipOpen(content,state,id) {
		$(".tipright p").text(content);
		$("#state").val(state);
		$("#id").val(id);
		$("#tip").fadeIn(200);
	}
	function tipClose() {
		$("#tip").fadeOut(200);
	}
	function sendOrbackOrder(state,id){
		window.location.href="${prc}/orderServlet?method=sendOrbackOrder&oId="+id+"&oState="+state+"";
	}
</script>
<script type="text/javascript">
<%
Object sendResult = request.getAttribute("sendResult");
Object backResult = request.getAttribute("backResult");
  if("success".equals(sendResult)){%>    
      	alert("发货成功!");  
       window.location.href="${prc }/orderServlet?method=orderList"; 
<%}else if("fail".equals(sendResult)){ %>	
		alert("商品数量不足，发货失败!");
<%}%> 
<%if("success".equals(backResult)){%>    
	alert("确认退货成功!");  
	window.location.href="${prc }/orderServlet?method=orderList"; 
<%}%>
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>订单管理</li>
			<li>基本内容</li>
		</ul>
	</div>
	<div class="rightinfo">
		<form id="fm" name="fm" action="${prc }/orderServlet?method=orderList"
			method="post">
			<input id="inp" type="hidden" name="currentPage" value="" />
			<ul class="tools">
				<li>订单编号: <input type="text" id="inp1" name="serialNumber"
					value="${page.entity.serialNumber }" />
				</li>
				<li>状态: <select name="state" id="inp2">
						<option value="-1">请选择</option>
						<option value="0">未发货</option>
						<option value="1">已发货</option>
						<option value="2">已完成</option>
						<option value="4">退货中</option>
						<option value="5">已退货</option>
				</select>
				</li>
				<li class="subBut" onclick="document.fm.submit();"><img
					src="${prc }/back/images/t06.png" />查询</li>
			</ul>
			<table class="tablelist">
				<thead>
					<tr>
						<th>序号</th>
						<th>订单编号</th>
						<th>金额</th>
						<th>下单时间</th>
						<th>收货人</th>
						<th>收货地址</th>
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
							<td>${order.customerName }</td>
							<td>${order.receivedAddress }</td>

							<c:if test="${order.orderState==0 }">
								<td>未发货</td>
								<td><a href="${prc }/orderServlet?method=orderView&orderId=${order.orderId}&currentPage=${page.currentPage}" class="tablelink">查看详情</a> <a
									href="javascript:void(0)" class="tablelink"
									onclick="tipOpen('确定此订单发货吗？',${order.orderState},${order.orderId })">发货</a></td>
							</c:if>
							<c:if test="${order.orderState==1 }">
								<td>已发货</td>
								<td><a href="${prc }/orderServlet?method=orderView&orderId=${order.orderId}&currentPage=${page.currentPage}" class="tablelink">查看详情</a></td>
							</c:if>
							<c:if test="${order.orderState==2 || order.orderState==7 }">
								<td>已完成</td>
								<td><a href="${prc }/orderServlet?method=orderView&orderId=${order.orderId}&currentPage=${page.currentPage}" class="tablelink">查看详情</a></td>
							</c:if>
							<c:if test="${order.orderState==4 }">
								<td>退货中</td>
								<td><a href="${prc }/orderServlet?method=orderView&orderId=${order.orderId}&currentPage=${page.currentPage}" class="tablelink">查看详情</a> <a
									href="javascript:void(0)" class="tablelink"
									onclick="tipOpen('确定收到此订单退货吗？',${order.orderState},${order.orderId })">确认已退货</a></td>
							</c:if>
							<c:if test="${order.orderState==5 }">
								<td>已退货</td>
								<td><a href="${prc }/orderServlet?method=orderView&orderId=${order.orderId}&currentPage=${page.currentPage}" class="tablelink">查看详情</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
		</form>
		<!-- 提示框 -->
		<div id="tip" class="tip">
		<input type="hidden" id="state"/>
		<input type="hidden" id="id"/>
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
					onclick="sendOrbackOrder($('#state').val(),$('#id').val())" /> &nbsp; <input name="" type="button"
					class="cancel" value="取消" onclick="tipClose()" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
