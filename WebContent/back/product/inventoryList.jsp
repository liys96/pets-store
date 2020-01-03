<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文本</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<link href="${prc }/back/css/productdetail.css"  rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">
var s1;
var s2;
 function go(num){		
	s1 = "${page.entity.commodityTitle }";
	s2 = "${page.entity.typesId }";
		$("#inp").val(num);
		$("#inp1").val(s1);
		$("#inp2").val(s2);
	$("#fm").submit();
}
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>库存管理</li>
  </ul>
</div>
<div class="rightinfo">
  <form id="fm" name="fm" action="${prc }/inventoryServlet?method=inventoryList" method="post">
  <input id="inp" type="hidden" name="currentPage" />
        <ul class="tools">
      <li> 商品名称:
        <input type="text" id="inp1" name="title" value="${page.entity.commodityTitle }"/>
      </li>
      <li> 商品类型:
        <select id="inp2" name="typesId">
         <option value="-1">请选择</option>
          <option value="2">狗狗主粮</option>
          <option value="4">狗狗零食</option>
          <option value="3">猫咪主粮</option>
          <option value="5">猫咪零食</option>
          <option value="6">宠物玩具</option>
        </select>
      </li>
      <li class="subBut" onclick="document.fm.submit();"><img src="${prc }/back/images/t06.png" />查询</li>
      <li class="subBut" onclick="window.location.href='${prc }/inventoryServlet?method=searchCommodity'"><img src="${prc }/back/images/t01.png" />添加</li>
    </ul>
    <table class="tablelist">
      <thead>
        <tr>
          <th>序号</th>
          <th>商品类型</th>
          <th>商品型号</th>
          <th>商品名称</th>
          <th>商品数量</th>
          <th>单位</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${page.list }" var="inventory">
        <tr>
          <td>${inventory.rn }</td>
          <td>${inventory.typesName }</td>
          <td>${inventory.marqueName }</td>
          <td>${inventory.commodityTitle }</td>
          <td>${inventory.inventoryAmount }</td>
          <td>${inventory.unit }</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
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
  </form>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
    