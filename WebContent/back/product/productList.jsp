<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<link href="${prc }/back/css/productdetail.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">
<%
Object result = request.getAttribute("result");
  if("success".equals(result)){%>    
      alert("添加成功!");  
       window.location.href="${prc }/commodityServlet?method=commodityList"; 
<%}else if("fail".equals(result)){ %>	
		alert("添加失败!");
<%}%> 
</script>
<script type="text/javascript">
var s1;
var s2;
var s3;
 function go(num){		
	s1 = "${page.entity.commodityTitle }";
	s2 = "${page.entity.typesId }";
	s3 = "${page.entity.state }";
		$("#inp").val(num);
		$("#inp1").val(s1);
		$("#inp2").val(s2);
		$("#inp3").val(s3);
	$("#fm").submit();
}


 function tipOpen(content,state,id) {
		$(".tipright p").text(content);
		$("#cId").val(id);
		$("#cState").val(state);
		$("#tip").fadeIn(200);
	} 
	function tipClose() {
		$("#tip").fadeOut(200);
	}
	  function updateState(id,state){
		window.location.href="${prc}/commodityServlet?method=updateState&cId="+id+"&cState="+state+"&currentPage="+${page.currentPage }+"";
	}
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>商品管理</li>
    <li>基本内容</li>
  </ul>
</div>
<div class="rightinfo">
  <form action="${prc }/commodityServlet?method=commodityList" method="post" id="fm" name="fm">
    <input id="inp" type="hidden" name="currentPage" />
    <ul class="tools">
      <li> 商品名称:
        <input type="text" id="inp1" name="title" value="${page.entity.commodityTitle }"/>
      </li>
      <li> 商品类型:
        <select id="inp2" name="typesId" >
          <option value="-1">请选择</option>
          <option value="2">狗狗主粮</option>
          <option value="4">狗狗零食</option>
          <option value="3">猫咪主粮</option>
          <option value="5">猫咪零食</option>
          <option value="6">宠物玩具</option>
        </select>
      </li>
      <li> 状态：
        <select id="inp3" name="state">
          <option value="-1">请选择</option>
          <option value="1">可用</option>
          <option value="0">不可用</option>
        </select>
      </li>
      <li class="subBut" onclick="document.fm.submit();"><img src="${prc }/back/images/t06.png" />查询</li>
      <li class="subBut" onclick="window.location.href='${prc }/back/product/productAdd.jsp'"><img src="${prc }/back/images/t01.png" />添加</li>
    </ul>
    <table class="tablelist">
      <thead>
        <tr>
          <th>序号</th>
          <th>商品名称</th>
          <th>商品图片</th>
          <th>商品类型</th>
          <th>商品型号</th>
          <th>主要成分</th>
          <th>净含量</th>
          <th>单价</th>
          <th>状态</th>
          <th>创建时间</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.list }" var="commodity">
        <tr>
          <td>${commodity.rn}</td>
          <td>${commodity.commodityTitle}</td>
          <td><img style="width:30px;height:30px" src="${prc }/downServlet?fileName=${commodity.commodityHeadpic}"/></td>
          <td>${commodity.typesName}</td>
          <td>${commodity.marqueName}</td>
          <td>${commodity.compositionName}</td>
          <td>${commodity.commodityQuantity}kg</td>
          <td>￥${commodity.commodityPrice}</td>
          <c:if test="${commodity.state ==1 }"><td>可用</td></c:if>
          <c:if test="${commodity.state ==0 }"><td>不可用</td></c:if>      
          <td>${commodity.createDate}</td>
          <td>
            <a href="${prc }/commodityServlet?method=searchCommodity&cId=${commodity.commodityId}" class="tablelink">修改</a>
           <c:if test="${commodity.state ==1 }">
			 <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认注销此条信息？',${commodity.state},${commodity.commodityId})">注销</a>          	</c:if>
          	<c:if test="${commodity.state ==0 }">
			 <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认恢复此条信息？',${commodity.state},${commodity.commodityId})">恢复</a>          	</c:if>
                     
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
     <input type="hidden" id="cId" value="" />
      <input type="hidden" id="cState" value=""/>
      <input name="" type="button"  class="sure" value="确定" onclick="updateState($('#cId').val(),$('#cState').val())" />
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
    