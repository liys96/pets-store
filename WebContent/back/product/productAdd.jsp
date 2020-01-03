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
<script type="text/javascript">
$(function(){	
 	$.post("${prc}/typesServlet",function(data,textStatus){
		var jsondata = eval("("+data+")");
		//遍历json对象
		$(jsondata).each(function(index,domEle){
			var $option = $("<option/>");
			$option.attr("value",this.typesId);
			$option.text(this.typesName);
			$("#types").append($option);
		});
	}); 
	 //传递类型id，拿到对应的型号marqueId
	$("#types").change(function(){
		$("#marque option[value!=-1]").remove();
		$("#composition option[value!=-1]").remove();		
		var param = {"typesId":$(this).val()};
		$.post("${prc}/marqueServlet",param,function(data,textStatus){					
			var jsonObj = eval("("+data+")");
			$(jsonObj).each(function(){
				var $option = $("<option/>");
				$option.attr("value",this.marqueId);
				$option.text(this.marqueName);
				$("#marque").append($option);
				
			});
			getMaque();
		});

	});
	function getMaque(){
		var marqueId = $("#marque option:eq(0)").attr("value");
		var param = {"marqueId":marqueId};
		console.log(marqueId);
		$.post("${prc}/compositionServlet",param,function(data,textStatus){
			var jsondata = eval("("+data+")");
			console.log(jsondata);
			$(jsondata).each(function(index,domEle){
				var $option = $("<option/>");
				$option.attr("value",this.compositionId);
				$option.text(this.compositionName);
				$("#composition").append($option);
			});
		});
	}
		
	 
	 
	 
	//传递型号id，拿到对应的成分
	$("#marque").change(function(){
		$("#composition option[value!=-1]").remove();
		var param = {"marqueId":$(this).val()};
		$.post("${prc}/compositionServlet",param,function(data,textStatus){
			var jsondata = eval("("+data+")");
			$(jsondata).each(function(index,domEle){
				var $option = $("<option/>");
				$option.attr("value",this.compositionId);
				$option.text(this.compositionName);
				$("#composition").append($option);
			});
		});
	}); 
});
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>商品管理</li>
    <li>添加</li>
  </ul>
</div>
	
<div class="formbody">
  <div class="formtitle"><span>商品类型信息</span></div>
  <form id="fm" name="fm" action ="${prc }/commodityServlet?method=addCommodity" enctype="multipart/form-data" method="post">
  <ul class="forminfo">
    <li>
      <label  class="forminfo_li1">选择类型&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <select id="types" name="typesId">
          <option value="-1">商品类型</option>
        </select>&nbsp;&nbsp;&nbsp;&nbsp;         
      <select id="marque" name="marqueId">
          <option value="-1">商品型号</option>
        </select>&nbsp;&nbsp;&nbsp;&nbsp;
        <select id="composition" name="compositionId">   
          <option value="-1">商品成分</option>
        </select>
      <i>必选</i>
    </li>
    <li>
      <label>商品名称</label>
       <input name="title" type="text" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>商品图片</label>
      <input name="headPic" type="file"/>
    </li>
    <li>
      <label>净含量</label>
      <input name="quantity" type="text" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>单价</label>
      <input name="price" type="text" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>单位</label>
      <input name="unit" type="text" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>描述</label>
      <input name="description" type="text" class="dfinput" />
      <i>必填</i>
    </li>
    <li>
      <label>状态</label>
      <select class="dfselect" name="state">
          <option value="1">可用</option>
          <option value="0">不可用</option>
        </select>
      <i>必选</i>
    </li>
    <li>
      <label>&nbsp;</label>
      <input name="" type="button" class="btn" value="确定" onclick="document.fm.submit()"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="" type="button" class="btn" value="返回" onclick="window.location.href='${prc}/commodityServlet?method=commodityList'"/>
    </li>
  </ul>
  </form>
</div>
</body>
</html>
