<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${prc }/forward/css/productdetail.css" type="text/css" rel="stylesheet" />
<title>productdetail</title>
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">

var s1;
var s2;
 function go(num){		
		$("#inp").val(num);
	$("#fm").submit();
} 
 
</script>
</head>

<body>
	<div class="detail_container">
	<form id = "fm" name="fm" action="${prc }/productServlet?method=productList" method="post">
		<div class="condition">
			<a href="${prc }/productServlet?method=productList" class="condition_a condi_a1">默认</a>
			<a href="${prc }/productServlet?method=productList&AccSale='sal'" class="condition_a condi_a2">销量</a>
			<a href="${prc }/productServlet?method=productList&AccTime='sal'" class="condition_a condi_a2">新品</a>
			<a href="${prc }/productServlet?method=productList&AccAppraise='sal'" class="condition_a condi_a2">评论</a>
			<a href="${prc }/productServlet?method=productList&AccPrice='sal'" class="condition_a condi_a2">价格</a>
		</div>
		<input id="inp" type="hidden" name="currentPage" value="" />
		<div class="detail_main">
		<c:forEach items="${page.list }" var="list">
			<div class="detail_contai_all">
				<div class="contai_imgandtitle">
					<a href="${prc }/productServlet?method=searchCommodityInfo&cId=${list.commodityId}" target="_blank"><img src="${prc }/downServlet?fileName=${list.commodityHeadPic}"></a>				
				</div>
				<div class="detail_sailprice">
					<a  href="${prc }/productServlet?method=searchCommodityInfo&cId=${list.commodityId}" target="_blank">${list.commodityTitle }</a>
					<span class="price">￥${list.commodityPrice }</span>
					<span class="shouchu">已售${list.saleAmount }${list.commodityUnit }&nbsp;&nbsp;&nbsp;${list.appraiseAmount }评论</span>
				</div>
			</div>
			</c:forEach>
		</div>		
		
		<!--page页部分-->
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
				</form>
	</div>	
</body>
</html>