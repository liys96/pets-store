<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHome-宠物商店</title>
<link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
<link href="${prc }/forward/css/index.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${prc }/back/js/jquery.js"></script>
<script type="text/javascript" src="${prc }/forward/js/jquery.XYTipsWindow.min.2.8.js"></script>
<script src="${prc }/forward/js/index.js" type="text/javascript"></script>
<script type="text/javascript">
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
});
</script>
<script type="text/javascript">
function proList1(title){
	$('#ifr').attr('src','${prc }/productServlet?method=productList&title='+title+'');
}

function proList(cId){
	$('#ifr').attr('src','${prc }/productServlet?method=productList&comId='+cId+'');
}

function myShopCart(){

	<%
	Object result = request.getSession().getAttribute("customer");
	  if(result==null){%>    
	      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
	<%}else{ %>			
			window.location.href="${prc}/cartServlet?method=cartView"; 
	<%}%> 
	}
	
function myOrder(){

	<%
	Object result1 = request.getSession().getAttribute("customer");
	  if(result1==null){%>    
	      alert("对不起,您还没有登录,登陆后继续进行该操作!");         
	<%}else{ %>	
			
			window.location.href="${prc }/orderServlet?method=myOrder";
	<%}%> 
	}
</script>
</head>
<body>
	<!-- 网页头部 -->
		<div class="headerTop_container">
		<div class="headerTop">
			<a href="${prc }/back/login.jsp" target="_blank" class="BackManager" style="color:red;font-size:13px">（管理员入口）</a>
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
	
	<!-- 搜索栏及logo -->
	<div class="search_containers">
		<div class="search_container">
			<div class="search_left">
				<a href="index.jsp"><img class="top_log" src="${prc }/forward/images/search_left.png"></a>
			</div>
			<div class="search_right">
				<input type="text" class="search_txt" id="title" /> 
				<input type="button" class="search_btn" onclick="proList1($('#title').val())" value="搜索" />
				<div class="shop_car" onclick="myShopCart()">
					<img src="${prc }/forward/images/scar.png"><a target="_blank">我的购物车</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 模块选项+轮播 -->
	 <div class="part1">
		<!-- 左边 -->
		 <div class="part1_left">
			<div class="part1_left_menucontainer lmc1">狗狗主粮 >
				<div class="menu_show msh1">
					<div class="menu_show_p"><img src="images/menu_p1.jpg"><div>狗狗主粮</div></div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>幼犬粮</span><img src="${prc }/forward/images/dog_main1.png"></li>							
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(102)">鸡肉</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(103)">羊肉</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(104)">鱼肉</a></li>
						</ul>
					</div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>成犬粮</span><img src="${prc }/forward/images/dog_main2.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(105)">火鸡肉</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(106)">羊肉</a></li>
							<li class="ul_li_cont ul_li_cont"><a href="#" onclick="proList(107)">鱼肉</a></li>
						</ul>
					</div>
					<div class="menu_content_img1"></div>
				</div>
			</div>
			<div class="part1_left_menucontainer lmc2">狗狗零食 >
				<div class="menu_show msh2">
					<div class="menu_show_p"><img src="images/menu_p2.jpg"><div>狗狗零食</div></div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>罐头湿粮</span><img src="${prc }/forward/images/dog_minor1.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(108)">罐头</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(109)">餐盒</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(110)">妙鲜包</a></li>
						</ul>
					</div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>肉制零食</span><img src="${prc }/forward/images/dog_minor2.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(111)">鸡肉</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(112)">牛肉</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(113)">鸭肉</a></li>
						</ul>
					</div>
					<div class="menu_content_img2"></div>		
				</div>
			</div>
			<div class="part1_left_menucontainer lmc3">猫咪主粮 >
				<div class="menu_show msh3">
					<div class="menu_show_p"><img src="images/menu_p3.jpg"><div>猫咪主粮 </div></div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>幼猫粮</span><img src="${prc }/forward/images/cat_main1.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(114)">卡比</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(116)">美士</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(116)">Wellness</a></li>
						</ul>
					</div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>成猫粮</span><img src="${prc }/forward/images/cat_main2.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href=# onclick="proList(117)">天衡宝</a></li>
							<li class="ul_li_cont"><a href=# onclick="proList(118)">牛油果</a></li>
						</ul>
					</div>
					<div class="menu_content_img3"></div>				
				</div>
			</div>
			<div class="part1_left_menucontainer lmc4">猫咪零食 >
				<div class="menu_show msh4">
					<div class="menu_show_p"><img src="images/menu_p4.jpg"><div>猫咪零食</div></div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>主食罐</span><img src="${prc }/forward/images/cat_minor1.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href=# onclick="proList(119)">鸡肉</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(120)">牛肉</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(121)">鱼肉</a></li>
						</ul>
					</div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>零食罐</span><img src="${prc }/forward/images/cat_minor2.png"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(122)">鸡肉</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(123)">牛肉</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(124)">鱼肉</a></li>
						</ul>
					</div>
					<div class="menu_content_img4"></div>				
				</div>
			</div>
			<div class="part1_left_menucontainer lmc5">宠物玩具 > 
				<div class="menu_show msh5">
					<div class="menu_show_p"><img src="images/menu_p5.jpg"><div>宠物玩具</div></div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>食用玩具</span><img src="${prc }/forward/images/toy1.jpg"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(125)">憨八龟</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(126)">美丽花朵</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(127)">甜心萝卜</a></li>
						</ul>
					</div>
					<div class="menu_show_content">
						<ul class="menu_content_ul">
							<li class="menu_content_ul_li1 ul_li_rightborder"><span>木质玩具</span><img src="${prc }/forward/images/toy2.jpg"></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(128)">美国进口</a></li>
							<li class="ul_li_rightborder ul_li_cont"><a href="#" onclick="proList(129)">迷宫</a></li>
							<li class="ul_li_cont"><a href="#" onclick="proList(130)">战斗机</a></li>
						</ul>
					</div>
					<div class="menu_content_img5"></div>				
				</div>				
			</div>
		</div> 
		
		<!-- 右边 -->
		 <div class="part1_right">
			<div class="bg_img1 bacge" name="pic"></div>
			<div class="bg_img2 bacge" name="pic" style="display: none"></div>
			<div class="bg_img3 bacge" name="pic" style="display: none"></div>
			<div class="bg_img4 bacge" name="pic" style="display: none"></div>
			<div class="cc">
				<ul>
					<a href="#"><li name="dian" onclick="showPic(0);"
						style="background-color: #0d8fdd;"></li></a>
					<a href="#"><li name="dian" onclick="showPic(1);"></li></a>
					<a href="#"><li name="dian" onclick="showPic(2);"></li></a>
					<a href="#"><li name="dian" onclick="showPic(3);"></li></a>
				</ul>
			</div>
		</div> 
		<!-- 右3图 -->
		  <div class="part1_right1">
			<div class="im_r1 im_r"></div>
			<div class="im_r2 im_r"></div>
			<div class="im_r3 im_r"></div>
		</div> 
	</div> 
	
	
		<div id="main">
		<!--iframe部分，在此处插入相应的网页，宽度为1366px-->
		<!--多iframe页面命名使用menu+num命名 例如menu1.html-->
		<!--onload="this.height=ifr.document.body.scrollHeight"-->
		<!--onload=iframeLoad()-->
		<iframe name="ifr" id="ifr" style="border: none;"
			onload="this.height=ifr.document.body.scrollHeight" width="100%"
			scrolling="no" src="${prc }/productServlet?method=productList"></iframe>

	</div>

	<!--网站页面底部公司信息-->
	<div id="footter" style="background-color:#ddd;">
		<div class="company_info">
			<div class="company_name">PHome——宠物商店</div>
			<div class="company_tel">
				<ul>
					<li>关于PHome</li>
					<li class="line"></li>
					<li>联系我们</li>
					<li class="line"></li>
					<li>咨询服务热线</li>
					<li class="line"></li>
					<li>0791-3455343</li>
				</ul>
			</div>
			<div class="company_copy">赣ICP备 14001557号
				CopyRight&copy;2018-2019 PHome </div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function toCart(){
		window.location.href="cart/mycart.jsp";
	}
</script>
</html>