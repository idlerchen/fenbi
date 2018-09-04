$(function(){
	
	$(".header-course").addClass("active").children().addClass("active");
	
	//导航栏返回
	$("div .course-detail-navi").children(":first").click(function(){
		var courseTypeId = $(this).attr("id");
		window.location = "CourseServlet?way=getCourseByCourseTypeId&courseTypeId="+courseTypeId;
	});
	
	//购买时间
	$("#buy").click(function(){
		var courseId = $("#buy").attr("data-courseId");
		window.location = "OrderServlet?way=previewOrder&courseId=" + courseId;
	});
});