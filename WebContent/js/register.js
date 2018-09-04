$(function() {
	//更换验证码JS
	$('#code').click(function () { 
		window.location = "validateCode";
		});
	
	//验证输入的账号数据库中是否存在
	$("#fbuser").change(function(){
		var username = this.value;
		
		$.get("UserServlet",
				{"username":username, "way":"checkUser"},
				function(response){
					
					if(response =="1") {
						// 可用
						$("#checkMsg").html("用户名可用！");
						// 让提交按钮可用
						$("#btn_sub").attr("disabled",false);
					}else {
						// 不可用
						$("#checkMsg").html("该用户名已注册！");
						// 让提交按钮不可用
						$("#btn_sub").attr("disabled",true);
					}
				},
				"text"
		);
	});
	
});


    

