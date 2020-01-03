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
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>订购单管理</li>
			<li>订购单详情</li>
		</ul>
	</div>
	<div class="formbody">
		<div class="formtitle">
			<span>订购单信息</span>
		</div>
		<ul class="forminfo">
			<li><label>订单编号</label> <cite>${order.serialNumber }</cite></li>
			<li><label>客户姓名</label> <cite>${order.customerName }</cite></li>
			<li><label>联系电话</label> <cite>${order.customerPhoneNumber }</cite>
			</li>
			<li><label>下单时间</label> <cite>${order.orderDate }</cite></li>
			<li><label>总金额</label> <cite>￥${order.totalMoney }</cite></li>
			<li><label>收货地址</label> <cite>${order.receivedAddress }</cite></li>
			<li><label>状态</label> <cite> <c:if
						test="${order.orderState==0 }">
								未发货
								
							</c:if> <c:if test="${order.orderState==1 }">
								已发货
								
							</c:if> <c:if test="${order.orderState==2 }">
								已完成
								
							</c:if> <c:if test="${order.orderState==4 }">
								退货中
								
							</c:if> <c:if test="${order.orderState==5 }">
								已退货
								
							</c:if>
			</cite></li>
		</ul>
		<table class="tablelist">
			<thead>
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.rn }</td>
					<td>
					<img style="width:30px;height:30px;border-radius:20px" src="${prc }/downServlet?fileName=${list.commodityHeadpic}"/>
					${list.commodityTitle }</td>
					<td>${list.orderCommodityAmount }</td>
					<td>￥${list.commodityPrice }</td>
					<td>￥${list.orderCommodityMoney }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="margin-top: 20px; margin-left: 20px;">				
		<form name="fm" action="${prc}/orderServlet?method=orderList"  method="post">
		<input type ="hidden" id="cu" name="currentPage" value="${cu }"/>
			<input name="" type="button" class="btn" value="返回"
				onclick="document.fm.submit()" />
				</form>
		</div>		
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
