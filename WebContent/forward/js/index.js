	var index = 0;
	function showPic(a){
		clearInterval(time);
		var arr = document.getElementsByName("pic");
		var arr1 = document.getElementsByName("dian");
		for(var i = 0; i < arr1.length; i++){
			if(i == a){
				arr1[i].style.backgroundColor="#0d8fdd";
				arr[i].style.display="block";
			}else{
				arr[i].style.display = "none";
				arr1[i].style.backgroundColor = "";
			}
		}
		time = setInterval("picShow()", 3000);
	}
		
	
	function picShow(){
		var arr = document.getElementsByName("pic");
		var arr1 = document.getElementsByName("dian");
		for(var i = 0;i < arr1.length;i++){
			if(index == i){
				arr1[i].style.backgroundColor = "#0d8fdd";
				arr[i].style.display = "block"
			}else{
				arr1[i].style.backgroundColor = "";
				arr[i].style.display = "none"
			}
		}
		index++;
		if(index == 4){
			index = 0;	
		}
	}
	var time = setInterval("picShow()", 3000);
	
	
	
	