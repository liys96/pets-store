<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link href="${prc }/back/css/style.css" rel="stylesheet" type="text/css" />
<link href="${prc }/back/css/productdetail.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript">
var s1;
var s2;
var s3;
 function go(num){		
	s1 = "${page.entity.userName }";
	s2 = "${page.entity.userAccount }";
	s3 = "${page.entity.state }";
		$("#inp").val(num);
		$("#inp1").val(s1);
		$("#inp2").val(s2);
		$("#inp3").val(s3);
	$("#fm").submit();
} 

function tipOpen(content,state,id) {
$(".tipright p").text(content);
$("#userId").val(id);
$("#userState").val(state);
$("#tip").fadeIn(200);
} 

function tipOpen1(id) {
	$("#userId").val(id);
	$("#tip1").fadeIn(200);
	} 
	
function tipClose() {
$("#tip").fadeOut(200);
}
function tipClose1() {
	$("#tip1").fadeOut(200);
	}
function updateState(id,state){
window.location.href="${prc}/userServlet?method=updateState&userId="+id+"&userState="+state+"&currentPage="+${page.currentPage }+"";
}

function deleteUser(id){
	window.location.href="${prc}/userServlet?method=deleteUser&userId="+id+"&currentPage="+${page.currentPage }+"";

} 
</script>
<script type="text/javascript">
<%
Object result = request.getAttribute("success");
  if("success".equals(result)){ %> 
	window.location.href="${prc}/userServlet?method=userList&currentPage="+${page.currentPage };
<%}else if("fail".equals(result)){ %>	
		alert("修改失败!");
<%}%>
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">用户管理</a></li>
			<li><a href="#">用户管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<form action="${prc }/userServlet?method=userList" method="post"
			id="fm" name="fm">
			 <input id="inp" type="hidden" name="currentPage" value=""/>
			<ul class="tools">
				<li><label>名称:</label> <input type="text" id="inp1"
					name="userName" value="${page.entity.userName }" /></li>
				<li><label>账号:</label> <input type="text" id="inp2"
					name="userAccount" value="${page.entity.userAccount }" /></li>
				<li><label>状态：</label> <select id="inp3" name="userState">
						<option value="-1">请选择</option>
						<option value="1">可用</option>
						<option value="0">不可用</option>
				</select></li>
				<li class="subBut" onclick="document.fm.submit();"><img
					src="${prc }/back/images/t06.png" />查询</li>
				<li class="subBut"
					onclick="window.location.href='${prc}/back/customer/userAdd.jsp'"><img
					src="${prc }/back/images/t01.png" />添加</li>
			</ul>
			<table class="tablelist">
				<thead>
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>账号</th>
						<th>状态</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.list }" var="user">
						<tr>
							<td>${user.rn }</td>
							<td>${user.userName }</td>
							<td>${user.userAccount }</td>
							<c:if test="${user.state ==1 }">
								<td>可用</td>
							</c:if>
							<c:if test="${user.state ==0 }">
								<td>不可用</td>
							</c:if>
							<td>${user.createDate }</td>
							<td><a href="${prc }/userServlet?method=searchUserById&userId=${user.userId}" class="tablelink">修改</a> <c:if
									test="${user.state ==1 }">
									<a href="#" class="tablelink"
										onclick="tipOpen('是否确认注销此用户？',${user.state},${user.userId})">注销</a>&nbsp;&nbsp;
								</c:if> <c:if test="${user.state ==0 }">
									<a href="#" class="tablelink"
										onclick="tipOpen('是否确认恢复此用户？',${user.state},${user.userId})">恢复</a>&nbsp;&nbsp;
								</c:if> <a href="#" class="tablelink"
								onclick="tipOpen1(${user.userId})">删除</a></td>
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
				<input type="hidden" id="userId" value="" /> <input type="hidden"
					id="userState" value="" /> <input name="" type="button"
					class="sure" value="确定"
					onclick="updateState($('#userId').val(),$('#userState').val())" />
				&nbsp; <input name="" type="button" class="cancel" value="取消"
					onclick="tipClose()" />
			</div>
		</div>


		<!-- 删除提示框 -->
		 <div id="tip1" class="tip">
			<div class="tiptop">
				<span>提示信息</span><a onclick="tipClose()"></a>
			</div>
			<div class="tipinfo">
				<span><img src="${prc }/back/images/ticon.png" /></span>
				<div class="tipright">
					<p>确认删除此用户吗?</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>
			<div class="tipbtn">
				<input type="hidden" id="userId" value="" /> <input type="hidden"
					id="userState" value="" /> <input name="" type="button"
					class="sure" value="确定" onclick="deleteUser($('#userId').val())" />
				&nbsp; <input name="" type="button" class="cancel" value="取消"
					onclick="tipClose1()" />
			</div>
		</div> 
	</div>
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
