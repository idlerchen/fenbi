<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/day08_cgq_fenbi/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<fieldset>
    		<legend>省市区三级联动</legend>
    			省份:
		    	<select id="province" onchange="select_citys();">
		    		<!-- 循环显示所有省份 -->
		    		<c:forEach var="pv" items="${province}">
			    		<option value="${pv.id}">${pv.pname}</option>
		    		</c:forEach>
		    	</select>
		    	城市:
		    	<select id="city" onchange="select_areas()">
		    	</select>
		    	区域:
		    	<select id="area">
		    	</select>
    	</fieldset>
	<script type="text/javascript">
	function select_citys(){
		var op=$("#province option:selected");
		var provinceId=op.val();
		$.getJSON("OrderServlet",
				{"provinceId":provinceId,"way":"getCity"},
				function(response){
					$("#city").empty();
					$.each(response, function(i, d) {
						
						$("#city").append(
								"<option value='"+d.Id+"'>" + d.cname
										+ "</option><br/>");
					});
				}
		);
	};
	
	 function select_areas(){
		var op=$("#city option:selected");
		var cityId=op.val();
		$.getJSON("OrderServlet",
				{"cityId":cityId,"way":"getCounty"},
				function(response){
					$("#area").empty();
					$.each(response, function(i, d) {
						$("#area").append(
								"<option value='"+d.Id+"'>" + d.ctname
										+ "</option><br/>");
					});
				}
		);
	}; 

	</script>
</body>
</html>