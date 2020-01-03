<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>注册</title>
<style type="text/css">
body,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,legend,button,input,textarea,th,td{margin:0;padding:0}
body,button,input,select,textarea{font:12px/1.5 tahoma,arial,\5b8b\4f53,sans-serif;text-align:justify;text-justify:inter-ideograph;word-break:break-all;word-wrap:break-word}
h1,h2,h3,h4,h5,h6{font-size:100%}
address,cite,dfn,em,var,i,u{font-style:normal}
code,kbd,pre,samp{font-family:courier new,courier,monospace}
small{font-size:12px}ul,ol{list-style:none}
sup{vertical-align:text-top}sub{vertical-align:text-bottom}
legend{color:#000}fieldset,img{border:0}button,input,select,textarea{font-size:100%;padding:0;margin:0}
table{border-collapse:collapse;border-spacing:0}caption,th{ text-align:left }
.ovh{overflow:hidden}.l{float:left}.r{float:right}.cur{cursor:pointer}
.c_b{content:".";display:block;height:0;clear:both;visibility:hidden;zoom:1;font-size:0px;overflow:hidden;visibility:hidden}.c_b2{clear:both}.dn{display:none}.dis{display:block}.b{font-weight:bold}
body{behavior:url("css/hover_htc.htc");font-family:"Microsoft YaHei",宋体; color:#333;}/*hover*/

/*会员注册*/
.login ul{/*background:url(../images/line.png) repeat-x;*/ padding-top:10px; border-top:1px solid #fff}
.login ul a{ color:#005cb1}
.login .id input,.login .pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{background-color:#FFF; border:1px solid #d5cfc2;  font-size:14px; font-weight:bold; vertical-align:middle}
.login .id input,.login .pw input{width:170px; height:30px;margin:0 5px 5px 0; line-height:30px; padding:0 5px;}
.login .id input:hover,.login .pw input:hover,.in_id:hover,.in_mo:hover,.reg_input:hover,.reg_input_pic:hover{border:1px solid #005cb1;background-color:#F2FAFF;}
.l_button,.r_button{background:url(${prc}/forward/images/login_button.png) no-repeat; width:118px; height:39px; border:none; cursor:pointer; display:block; float:left; text-indent:-9000px}
.l_button{background-position:0 -60px;}
.r_button{background-position:-138px -60px; margin-right:4px}
.l_button:hover{background-position:0 0;}
.r_button:hover{background-position:-138px 0;}
.f_reg_but{margin:10px 0 0 161px}

.reg{width:460px; font-size:14px;line-height:25px; overflow:hidden;}
.reg dl{padding-left:42px; font-size:14px;}
.reg dl dt{ margin-top:15px}
.reg dl dd{padding:3px 0}
.reg .title{width:100px; display:inline-block; text-align:right; padding-right:10px}
.reg_input_pic{width:80px;}
.in_pic_s{margin-left:83px}
.reg .img{position:absolute}
.onShow,.onFocus,.onError,.onCorrect,.onLoad{background:url(images/reg_bg.png) no-repeat 3000px 3000px;padding-left:30px; font-size: 12px; height:25px; width:124px; display:inline-block; line-height:25px; vertical-align:middle; overflow:hidden; margin-left:6px}
.onShow{color:#999; padding-left:0px}
.onFocus{background-position:0px -30px; color:#333}
.onError{background-position:0px -60px; color:#333}
.onCorrect{background-position:0px 0; text-indent:-9000px}
.onLoad{background-position:0px 0}
.reg_m{margin-left:90px}
.clew_txt{display:inline-block; padding:7px  0 0 15px; font-size:12px;}

.id input,.pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{_behavior:url(js/Round_htc.htc);-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px; height:25px;}
.user_button a,.pay_but{_behavior:url(js/Round_htc.htc);-moz-border-radius:100px;-webkit-border-radius:100px;border-radius:100px;}

#one1,#one2{display:block; background-color:#e9eed8; padding:5px 0; text-align:center; clear:both; cursor:pointer}
#one2{margin-top:15px}
#one1:hover,#one2:hover{background-color:#d4dfb0}
#one1 span,#one2 span{color:#F00}
</style>

<script src="${prc}/forward/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="${prc}/forward/js/formValidator_min.js" type="text/javascript" charset="UTF-8"></script>
<script src="${prc}/forward/js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
<%
   Object result = request.getAttribute("result");
     if("fail".equals(result)){%>    
         alert("账号重复请更换一个!");         
 <%}else if("success".equals(result)){ %>	
 		alert("恭喜注册成功!");
 		top.location.href="forward/index.jsp";
 <%}else if("isNull".equals(result)){ %>
 		alert("请填写完整信息，不允许出现空!");
 <%}%>
  
 </script>
</head>
<body>
<!--注册开始-->
    <div class="reg">
        <form name="form1" id="form1" action="${prc}/customerServlet?method=customerRegister" method="post"  enctype="multipart/form-data">
            <dl>
                <dt class="f14 b">帐户基本信息</dt>
                <dd><span class="title">登录账号：</span><input class="reg_input" name="customerAccount" id="t_UserName" onblur="" type="text" /><span id="t_UserNameTip" class="onshow"></span></dd>
                <dd><span class="title">姓名：</span><input class="reg_input" name="customerName" id="iptNickName" onblur="" type="text" /><span id="iptNickNameTip" class="onshow"></span></dd>
                <dd><span class="title">联系电话：</span><input class="reg_input" name="phoneNumber" id="phoneNum" onblur="" type="text" /><span id="iptNickNameTip" class="onshow"></span></dd>
                <dd><span class="title">性别：</span><input type="radio" id="Sex_Man" name="customerSex" value="男"  checked="checked" /><label for="Sex_Man"> 男</label>
                                                    <input type="radio" id="Sex_Woman" name="customerSex" value="女"  /><label for="Sex_Woman"> 女</label>　                                                  
              </dd> 
                <dd><span class="title">头像：</span><input class="reg_input" name="headPic"  type="file" /></dd>            
            </dl>
            <dl>
                <dt class="f14 b">帐户安全设置</dt>
                <dd><span class="title">登录密码：</span><input class="reg_input" onblur="" id="t_UserPass" name="loginPassword" type="password"/><span id="t_UserPassTip" class="onshow"></span></dd>
                <dd><span class="title">支付密码：</span><input name="payPassword" id="payPass" class="reg_input" type="password" onblur="" /><span id="iptNameTip" class="onshow"></span></dd>
                <dd><span class="title">收货地址：</span><input class="reg_input" name="receivedAddress" type='text' onblur="" /><span id="iptCardTip" class="onshow"></span></dd>               
            </dl>
            <div class="f_reg_but"><input id="button" name="button" type="submit"  value="立即注册" class="r_button"/></div>
        </form>                              
    </div>
<!--注册结束-->        
</body>
</html>