
$(function(){
	//页面加载完将地址加载进来
	$.get("AddressServlet",
			{"way":"getProvince"},
			function(response){
				if(response.code == 1){
					$("#city_code option:gt(0)").remove();
					$("#county_code option:gt(0)").remove();
					var provinces = response.province;
					
					$.each(provinces,function(i,province){
						var provinceId = province.Id;
						var name = province.pname;
						$("#province_code").append(
								"<option value='"+provinceId+"'>" + name
								+ "</option>");
					});
				}else{
					
				}
			},
	'json');
	
	//根据省响应市
	$("#province_code").change(function(){
		var provinceId = this.value;
		//获取到省Id，发送ajax请求获取所有市
		$.get("AddressServlet",
				{"way":"getCity","provinceId":provinceId},
				function(response){
					$("#city_code option:gt(0)").remove();
					$("#county_code option:gt(0)").remove();
					if(response.code == 1){
						var citys = response.city;
						$.each(citys,function(i,city){
							var cityId = city.Id;
							var cityname = city.cname;
							$("#city_code").append(
									"<option value='"+cityId+"'>" + cityname
									+ "</option>");
						});
					}else{
						
					}
				},
		'json');
	});
	
	$("#city_code").change(function(){
		var cityId = this.value;
		//获取到省Id，发送ajax请求获取所有市
		$.get("AddressServlet",
				{"way":"getCounty","cityId":cityId},
				function(response){
					$("#county_code option:gt(0)").remove();
					if(response.code == 1){
						var countys = response.county;
						$.each(countys,function(i,county){
							var countyId = county.countyId;
							var countyName = county.ctname;
							$("#county_code").append(
									"<option value='"+countyId+"'>" + countyName
									+ "</option>");
						});
					}else{
						
					}
				},
		'json');
	});
})










//支付选项的切换高亮
$(".course-order-pay-left").click(function(t) {
    $(".course-order-pay-way").removeClass("active"),
    $(".course-order-pay-way .selected").removeClass("selected");
    var i = $(t.currentTarget);
    i.parent().addClass("active"),
    i.find(".payradio").addClass("selected")
});

//保存地址发送请求并判断各个select的合法性
$("#saveaddress").click(function() {
	// 先判断地址各个信息的合法性，然后提示用户或者显示新界面
	var receiver =  $("#usernameaddress").val();
	var provinceId =  $("#province_code").val();
	var cityId =  $("#city_code").val();
	var countyId =  $("#county_code").val();
	var address =  $("#detailaddress_id").val();
	var telephone =  $("#phoneaddress").val();
	var reg = /^1[3456789]\d{9}$/g;
	 
	$(".address-name-tooltip").css("visibility", "hidden");
	$(".address-detail-tooltip").css("visibility", "hidden");
	$(".address-phone-tooltip").css("visibility", "hidden");
	 
	if(receiver == ""){
		$(".address-name-tooltip").css("visibility", "visible");
		return false;
	}else {
		$(".address-name-tooltip").css("visibility", "hidden");
	}
	 
	if(provinceId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选择省/直辖市");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(cityId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选择市");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(countyId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选县/区");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(address == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请填写详细地址");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(telephone == "" || !reg.test(telephone)){
		$(".address-phone-tooltip").css("visibility", "visible");
		$(".address-phone-tooltip>text").text("请填写正确的手机号码");
		return false;
	}else {
		$(".address-phone-tooltip").css("visibility", "hidden");
	}
	 
	//插入地址，ajax请求servlet并重载当前页面重新判断是否有默认地址
	$.post("AddressServlet",
		  {"way":"saveAddress","receiver":receiver,"provinceId":provinceId,"cityId":cityId,"countyId":countyId,"address":address,"telephone":telephone,"isDefault":"Y"},
		  function(response){
			  if(response.code == true){
			 	location.reload();
			  }
			  else{
				  alert(response.code);
			  }
		  },
		  'json'
	);
	
	 
});

//点击立即支付后插入订单信息
$("#paybutton").click(function(){
	
	var courseId = $("#courseId").attr("data-courseId");
	var courseTitle = $("#courseTitle").text();
	var startTime = $("#startTime").attr("data-startTime");
	var endTime = $("#endTime").attr("data-endTime");
	var lessonCount = $("#lessonCount").attr("data-lessonCount");
	var price = $("#price").text();
	
//	alert(courseId+"-"+courseTitle+"-"+startTime+"-"+endTime+"-"+lessonCount+"-"+price);
	
	var pname = $("#pname").text();
	var cname = $("#cname").text();
	var ctname = $("#ctname").text();
	var address = $("#address").text();
	var receiver = $("#receiver").text();
	var telephone = $("#telephone").text();
	
	var pay = $(".payradio.selected").attr("data-payway");
	var payway = 0;
	if(pay == "weixin"){
		payway = 0;
	}else{
		payway = 1;
	}
	
	$.post("OrderServlet",
			{"way":"saveOrder","courseId":courseId,"courseTitle":courseTitle,"startTime":startTime,"endTime":endTime,"lessonCount":lessonCount,"price":price,"receiver":receiver,"provinceName":pname,"cityName":cname,"countyName":ctname,"address":address,"telephone":telephone,"payway":payway},
			function(response){
				if(response.code == 1){
					window.location = "MyCourseServlet?way=getMyCourse";
				}else{
					alert(response.msg);
				}
			},
			'json');	
});






