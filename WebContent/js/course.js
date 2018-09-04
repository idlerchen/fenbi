$(function(){
	
	$(".header-course").addClass("active").children().addClass("active");
	
//	$(".truman-body-course-info").click(function(){
//		location.href = "page/course/course_detail.jsp";
//	});
	
	$("div .btn-group,truman-filter-item").click(function(){
		var courseTypeId = $(this).attr("id");
		window.location = "CourseServlet?way=getCourseByCourseTypeId&courseTypeId="+courseTypeId;
	});
	
	$("div .truman-body-course-info").click(function(){
		var courseId = $(this).attr("id");
		window.location = "CourseServlet?way=getCourseByCourseId&courseId="+courseId;
	});
});