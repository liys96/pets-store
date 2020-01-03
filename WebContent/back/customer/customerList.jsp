<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../../commons/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户管理</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<link href="${prc }/back/css/productdetail.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script>
	var s1;
	var s2;
	var s3;
	 function go(num){		
		s1 = "${page.entity.customerName }";
		s2 = "${page.entity.customerAccount }";
		s3 = "${page.entity.state }";
			$("#inp").val(num);
			$("#inp1").val(s1);
			$("#inp2").val(s2);
			$("#inp3").val(s3);
		$("#fm").submit();
	} 
	
function tipOpen(content,state,id) {
	$(".tipright p").text(content);
	$("#custId").val(id);
	$("#custState").val(state);
	$("#tip").fadeIn(200);
} 
function tipClose() {
	$("#tip").fadeOut(200);
}
  function updateState(id,state){
	window.location.href="${prc}/customerServlet?method=updateState&custId="+id+"&custState="+state+"&currentPage="+${page.currentPage }+"";
}
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>营销管理</li>
    <li>客户管理</li>
    <li>基本内容</li>
  </ul>
</div>
<div class="rightinfo">
  <form action="${prc }/customerServlet?method=customerList" method="post" id="fm" name="fm">
  <input id="inp" type="hidden" name="currentPage" value=""/>
    <ul class="tools">
      <li> 名称:
        <input type="text" size="12" id="inp1" name="customerName" value="${page.entity.customerName }" />
      </li>
      <li> 账号:
        <input type="text" size="12"  id="inp2" name="customerAccount" value="${page.entity.customerAccount }" />
      </li>
      <li> 状态：
        <select id="inp3" name="customerState" >
          <option value="-1">请选择</option>
          <option value="1">可用</option>
          <option value="0">不可用</option>
        </select>
      </li>
      <li class="subBut" onclick="document.fm.submit();" ><img src="${prc }/back/images/t06.png" />查询</li>
    </ul>
    <table class="tablelist">
      <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>性别</th>
          <th>账号</th>
          <th>联系电话</th>
          <th>状态</th>
          <th>注册时间</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.list }" var="customer">
        <tr>
          <td>${customer.rn }</td>
          <td>${customer.customerName }</td>
          <td>${customer.customerSex }</td>
          <td>${customer.customerAccount }</td>
          <td>${customer.phoneNumber }</td>
          <c:if test="${customer.state ==1 }"><td>可用</td></c:if>
          <c:if test="${customer.state ==0 }"><td>不可用</td></c:if>          
          <td>${customer.createDate }</td>
          <td>
          	<a href="${prc }/customerServlet?method=searchCustomerById&customerId=${customer.customerId}" class="tablelink">查看详情</a>
          	<c:if test="${customer.state ==1 }">
          		<a href="#" class="tablelink" onclick="tipOpen('是否确认注销此用户？',${customer.state},${customer.customerId})">注销</a>
          	</c:if>
          	<c:if test="${customer.state ==0 }">
            	<a href="#" class="tablelink" onclick="tipOpen('是否确认恢复此用户？',${customer.state},${customer.customerId})">恢复</a>
          	</c:if>
          </td>
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
  <!-- 提示框 -->
  <div id="tip" class="tip">
    <div class="tiptop"><span>提示信息</span><a onclick="tipClose()"></a></div>
    <div class="tipinfo"> <span><img src="${prc }/back/images/ticon.png" /></span>
      <div class="tipright">
        <p></p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite> </div>
    </div>
    <div class="tipbtn">
      <input type="hidden" id="custId" value="" />
      <input type="hidden" id="custState" value=""/>
      <input name="" type="button"  class="sure" value="确定" onclick="updateState($('#custId').val(),$('#custState').val())" />
      &nbsp;
      <input name="" type="button"  class="cancel" value="取消" onclick="tipClose()" />
    </div>
  </div>
</div>
<script type="text/javascript">
$('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
