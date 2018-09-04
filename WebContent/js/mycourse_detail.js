$(function(){
	
	$(".header-mylectures").addClass("active").children().addClass("active");
	
	
	$("div .course-detail-navi").children(":first").click(function(){
		var courseTypeId = $(this).attr("id");
		window.location = "MyCourseServlet?way=getMyCourseByCourseTypeId&courseTypeId="+courseTypeId;
	});
});