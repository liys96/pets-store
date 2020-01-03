<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp" %>
<!DOCTYPE html>
<html>
    <head>      
        <title>宠物商店后台登录</title>
        <link rel="stylesheet" href="${prc }/back/css/reset.css">
        <link rel="icon" href="${prc }/back/images/icon.png" type="image/x-icon" />
        <script src="${prc }/back/js/jquery.js" type="text/javascript"></script>
        <script src="${prc }/back/js/supersized.3.2.7.min.js"></script>
        <link rel="stylesheet" href="${prc }/back/css/supersized.css">
        <link rel="stylesheet" href="${prc }/back/css/style-2.css">
<script type="text/javascript">
jQuery(function($){

    $.supersized({

        // Functionality
        slide_interval     : 6000,    // Length between transitions
        transition         : 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed   : 3000,    // Speed of transition
        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width          : 0,    // Min width allowed (in pixels)
        min_height         : 0,    // Min height allowed (in pixels)
        vertical_center    : 1,    // Vertically center background
        horizontal_center  : 1,    // Horizontally center background
        fit_always         : 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
        fit_portrait       : 1,    // Portrait images will not exceed browser height
        fit_landscape      : 0,    // Landscape images will not exceed browser width

        // Components
        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides             : [    // Slideshow Images
                                 {image : '${prc}/back/images/1.jpg'},
                                 {image : '${prc}/back/images/2.jpg'},
                                 {image : '${prc}/back/images/3.jpg'}
                             ]

    });

});

 </script> 
    </head>
    <body>
        <div class="page-container">
            <h1>宠物商店后台登录</h1>
           <form id="fm" name="fm" action="${prc }/userServlet?method=userLogin" method="post">
				<div>
					<input type="text" name="userAccount" class="username" placeholder="用户名" />
				</div>
                <div>
					<input type="password" name="userPassword" class="password" placeholder="密码"  />
                </div>
                <button type="submit" id="submit" >登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
            </form>
            <div class="connect">
                <p>lys's宠物商店后台系统.</p>
            </div>
        </div>
		<div class="alert" style="display:none">
			<h2>消息</h2>
			<div class="alert_con">
				<p id="ts"></p>
				<p style="line-height:70px"><a class="btn">确定</a></p>
			</div>
		</div>

		<script>
		$("#submit").click(function(){
			$("#fm").submit();
		})
		$(".btn").click(function(){
			is_hide();
		})
		window.onload = function()
		{
			$(".connect p").eq(0).animate({"left":"0%"}, 600);
			$(".connect p").eq(1).animate({"left":"0%"}, 400);
		}
		function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
		function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }		
		function is_show1(){ 
			$(".alert").show().animate({"top":"45%"}, 300) 
			$(".btn").click(function(){				
				window.location.href="${prc}/back/main.jsp";
			})	
		}
		<%
		   Object result = request.getAttribute("result");
		     if("2".equals(result)){%> 
		     $("#ts").html("用户名或密码错误~");
		     is_show();
		 <%}else if("success".equals(result)){ %>	
		 		$("#ts").html("登录成功~");
	     		is_show1();
		 <%}else if("0".equals(result)){ %>
		 		$("#ts").html("用户已被注销，请联系管理员lys~");
	     		is_show();
		 <%}%>
		</script>
    </body>

</html>