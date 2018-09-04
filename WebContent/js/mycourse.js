$(function(){
	
	$(".header-mylectures").addClass("active").children().addClass("active");
	
	// 设置点击课程跳转到课程详情
//	$(".truman-body-course-info").click(function(){
//		location.href = "page/mycourse/course_detail.jsp";
//	});
	
	$("div .btn-group,truman-filter-item").click(function(){
		var courseTypeId = $(this).attr("id");
		window.location = "MyCourseServlet?way=getMyCourseByCourseTypeId&courseTypeId="+courseTypeId;
	});
	
	$("div .truman-body-course-info").click(function(){
		var courseId = $(this).attr("id");
		window.location = "MyCourseServlet?way=getMyCourseByCourseId&courseId="+courseId;
	});
	
});