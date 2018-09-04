//页面加载时加载地址
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
	$("#province_code").change(function(event, city){
		var select = city;
		var provinceId = this.value;
		//获取到省Id，发送ajax请求获取所有市
		$.get("AddressServlet",
				{"way":"getCity","provinceId":provinceId},
				function(response){
					$("#city_code option:gt(0)").remove();
					$("#county_code option:gt(0)").remove();
					if(response.code == 1){
						var citys = response.city;
						$.each(citys,function(i,cityn){
							var cityId = cityn.Id;
							var cityname = cityn.cname;
							if(select == cityId){
								$("#city_code").append(
										"<option value='"+cityId+"' selected='selected'>" + cityname
										+ "</option>");
							}else{
							$("#city_code").append(
									"<option value='"+cityId+"'>" + cityname
									+ "</option>");
							}
						});
					}else{
						
					}
				},
		'json');
	});
	
	$("#city_code").change(function(event,cty){
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
							console.log(countyId);
							if(cty == countyId){
								$("#county_code").append(
										"<option value='"+countyId+"' selected='selected'>" + countyName
										+ "</option>");
							}
							else{
								$("#county_code").append(
										"<option value='"+countyId+"'>" + countyName
										+ "</option>");
							}
							
						});
					}else{
						
					}
				},
		'json');
	});
})







// 保存地址按钮点击事件
$("#saveaddress").click(function() {
	
//	alert($('#province_code option:selected').text());
	
	// 先判断地址各个信息的合法性，然后提示用户或者显示新界面
	var receiver =  $("#usernameaddress").val();
	var provinceId =  $("#province_code").val();
	var cityId =  $("#city_code").val();
	var countyId =  $("#county_code").val();
	var address =  $("#detailaddress").val();
	var telephone =  $("#phoneaddress").val();
	var reg = /^1[3456789]\d{9}$/g;
	 
	$(".address-name-tooltip").css("visibility", "hidden");
	$(".address-detail-tooltip").css("visibility", "hidden");
	$(".address-phone-tooltip").css("visibility", "hidden");
	 
	if(receiver == ""){
		$(".address-name-tooltip").css("visibility", "visible");
		return;
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
	 
	//保存时插入新地址，并重载页面加入到下方列表中
	$.post("AddressServlet",
			  {"way":"saveAddress","receiver":receiver,"provinceId":provinceId,"cityId":cityId,"countyId":countyId,"address":address,"telephone":telephone,"isDefault":"N"},
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
	//插入地址后输入框清空
	$("#usernameaddress").val("");
	$("#detailaddress").val("");
	$("#phoneaddress").val("");
	
});


$("tbody").on("click", ".tb-choose-radio,.tb-region,.tb-address,.tb-name,.tb-phone",
	function(t) {
		 $(".addressradio").removeClass("selected"),
		 $(t.currentTarget).parent().find(".addressradio").addClass("selected")
});

$("tbody").on("click", ".notdefault",
	function(t) {}
);

//修改操作
$("tbody").on("click", ".update",
function(t) {
	// 清除提示
    $(".address-illegal-tooltip").css("visibility", "hidden");
    
    // 获取当前被点击的a标签的父节点的父节点，就是tr节点
    var trEle = $(t.currentTarget).parent().parent();
    // 获取data-addressid,就是地址id
    var addressId = trEle.attr("data-addressid");
    
    // 给保存按钮添加一个属性，值为addressId
    $("#saveeditaddress").attr("data-addressid", addressId);
    
    // 获取收件人的姓名,省,市,区
    var receiver = trEle.find(".tb-name").text();
    var provinceName = trEle.find(".tb-province").text();
    var cityName = trEle.find(".tb-city").text();
    var countyName = trEle.find(".tb-county").text();
    var address = trEle.find(".tb-address").text();
    var telephone = trEle.find(".tb-phone").text();
    
    var provinceId = trEle.find(".tb-province").attr("data-provinceId");
    var cityId = trEle.find(".tb-city").attr("data-cityId");
    var countyId = trEle.find(".tb-county").attr("data-countyId");
    
    
    $("#province_code>option[value='" + provinceId + "']").attr("selected","selected");
    getCitySelected(provinceId,cityId);
    getCountySelected(cityId,countyId);
    
//    $("#province_code").trigger("change",[cityId]);
//    alert('修改地址');
//    
//    $("#city_code").trigger("change",[countyId]);
    
    // 给编辑框赋值
    $("#usernameaddress").val(receiver);
    $("#phoneaddress").val(telephone);
    $("#detailaddress").val(address);
    
    $("#saveaddress").css("display", "none");
    $("#saveeditaddress").css("display", "inline-block");
    $("#canceleditaddress").css("display", "inline-block");
    scroll(0, 0);
});

//根据省份id获取城市,并将指定的id的城市选中
function getCitySelected(provinceId,cityId) {
	
	$("#city_code option:gt(0)").remove();
	$("#county_code option:gt(0)").remove();
	
	$.getJSON(
			"AddressServlet",
			{"provinceId":provinceId,"way":"getCity"},
			function(response){
				
				if(response.code == 1) {
					
					$(response.city).each(function(){
						// 获取城市的id和name
						var id = this.Id;
						var name = this.cname;
						$("#city_code").append("<option value='"+id+"'>"+name+"</option>");
					});
					
					$("#city_code>option[value='" + cityId + "']").attr("selected","selected");
				}else {
					alert(response.msg);
				}
				
			}
		);
};

//根据城市id获取区县,并将指定的区县id的选中
function getCountySelected(cityId,countyId) {
	// 当城市发生改变以后，需要将原先的所有的县清除掉
	$("#county_code option:gt(0)").remove();
	
	// 发送请求获取区县的信息
	$.getJSON("AddressServlet",{
			"cityId":cityId,"way":"getCounty"},
			function(response){
				
				if(response.code == 1) {
					$(response.county).each(function(){
						$("#county_code").append("<option value='"+this.countyId+"'>"+this.ctname+"</option>");
					});
					
					$("#county_code>option[value='" + countyId + "']").attr("selected","selected");

				}else {
					alert(response.msg);
				}
				
			}
		);
}
//休眠代码
function sleep(n) {
    var start = new Date().getTime();
    while(true)  if(new Date().getTime()-start > n) break;
    }

$("#saveeditaddress").click(function(t) {
	
	// 获取需要修改的地址id
    var addressId = $("#saveeditaddress").attr("data-addressid");
	// 先判断地址各个信息的合法性，然后提示用户或者显示新界面
	var receiver =  $("#usernameaddress").val();
	var provinceId =  $("#province_code").val();
	var cityId =  $("#city_code").val();
	var countyId =  $("#county_code").val();
	var address =  $("#detailaddress").val();
	var telephone =  $("#phoneaddress").val();
	var reg = /^1[3456789]\d{9}$/g;
	 
	// 让提示的进行隐藏
	$(".address-illegal-tooltip").css("visibility", "hidden");
	 
	if(receiver == ""){
		$(".address-name-tooltip").css("visibility", "visible");
		return;
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
	
	//按照addressId、修改的值，update数据库中的地址。
	$.post("AddressServlet",
			  {"way":"AlterAddress","id":addressId,"receiver":receiver,"provinceId":provinceId,"cityId":cityId,"countyId":countyId,"address":address,"telephone":telephone},
			  function(response){
				  if(response.code == true){
				 	location.reload();
				  }
				  else{
					  alert(response.msg);
				  }
			  },
			  'json'
		);
	
	//修改完将输入框置空
	$("#usernameaddress").val("");
	$("#detailaddress").val("");
	$("#phoneaddress").val("");
	 
});


$("tbody").on("click", ".delete",
	function(t) {
	    var trEle = $(t.currentTarget).parent().parent();
	    var addressId = trEle.attr("data-addressid");
	    
	    $.post("AddressServlet",
	  		  {"way":"DeleteAddress","addressId":addressId},
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
	    
	    i = trEle.find(".addressradio").hasClass("selected"),
	    a = trEle.find(".tb-default").hasClass("isdefault");
	    
});

$("#canceleditaddress").click(function() {
    resetAddressInput();
    $("#saveaddress").css("display", "inline-block");
    $("#saveeditaddress").css("display", "none");
    $("#canceleditaddress").css("display", "none");
    location.reload();
});

function resetAddressInput(){
	
	// 让提示的进行隐藏
	$(".address-illegal-tooltip").css("visibility", "hidden");
	
	$("#usernameaddress").val("");
	$("#detailaddress").val("");
	$("#phoneaddress").val("");
}


//给设为默认的按钮添加点击事件，设为默认将次地址设为默认地址，其他地址都变成非默认地址
$("tbody").on("click", ".notdefault",
	function(t) {
		var addressId = $(t.currentTarget).parent().attr("data-addressid");
		$.post("AddressServlet",
				{"way":"UpdateAddress","addressId":addressId},
				function(response){
					if(response.code > 2){
						location.reload();
						// 将原先是默认的设置成不是默认，然后设置按钮文字为"设为默认"
//	    			    $(".isdefault").removeClass("isdefault").addClass("notdefault");
//	    			    $(".isdefault").find("button").text("设置默认");
//	    			    
//	    			    // 当前被点击的设置成默认
//	    			    $(t.currentTarget).removeClass("notdefault").addClass("isdefault");
//	    			    $(t.currentTarget).find("button").text("默认地址");
					}else{
						alert(response.msg);
					}
				},
				'json'
		);
	
});


//点击确认收货地址，将选中的地址传回到之前页面/以及课程ID
$("#confirmaddress").click(function(){
	var courseId = $("#confirmaddress").attr("data-courseId");
	var addressId = $(".addressradio.selected").parent().parent().attr("data-addressId");
//	alert("OrderServlet?way=previewOrder&courseId="+courseId+"addressId="+addressId);
	window.location = "OrderServlet?way=previewOrder&courseId="+courseId+"&addressId="+addressId;
});










