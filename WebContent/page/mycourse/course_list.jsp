<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>粉笔网</title>
<%@ include file="/page/base/base.jsp" %>
<link rel="stylesheet" href="css/mycourse.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>
	
	<div id="truman-body" class="text-center">
		<div id="truman-body-course" class=" text-center">
			<div class="truman-body-filters text-center">
				<div id="" class="truman-filters-detail text-left">

					<c:forEach items="${courseTypeList }" var="courseType">
					<div id="${courseType.courseTypeId }" class="btn-group truman-filter-item">
						<button  type="button" class="btn${courseType.courseTypeId == param.courseTypeId ? ' choosing' : '' }">${courseType.courseTypeName }</button>
					</div>
				</c:forEach>

				</div>
			</div>
			
			<div class="truman-course-detail ">
				<div id="courseInfos" class="text-left">
					
					<c:if test="${!empty myCourseList }">
					<c:forEach items="${myCourseList}" var="course">
						<div id="${course.courseId }" class="truman-body-course-info ">
							<p class="course-info-title ">${course.courseTitle }</p>
							<p class="course-info-class ">
								<span class="time-icon"></span>&nbsp;&nbsp;<fmt:formatDate value="${course.startTime }" pattern="yyyy.M.d"/>&nbsp;-&nbsp;<fmt:formatDate value="${course.endTime }" pattern="yyyy.M.d"/>&nbsp;&nbsp;(${course.lessonCount }课时)
							</p>
							
							<div class="course-info-teachers text-left ">
								<c:forEach items="${course.teachers}" var="teacher">
									<div class="course-info-teacher-item text-center ">
										<img src="${teacher.photoUrl }" width="70px" height="71px">
										<p class="text-center ">
											<span>${teacher.teacherName }</span>
										</p>
									</div>
								</c:forEach>
							</div>
							
							<div class="course-info-split "></div>
							<div class="course-info-students ">
								<div class="course-info-student-number ">
									<p class="show-false student-str">${course.saleNum }人购买</p>
									<p class="show-false">
										<span></span>
									</p>
								</div>
								<div class="course-info-price show-commen ">
									¥&nbsp; <span><fmt:formatNumber value="${course.price }" pattern="#"></fmt:formatNumber></span>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty myCourseList }">
					<div class="course-empty-image text-center"></div>
				</c:if>
				
					<!-- <div id="3" class="truman-body-course-info ">
						<p class="course-info-title ">JAVA基础班图书大礼包：1期</p>
						<p class="course-info-class ">
							<span class="time-icon"></span>&nbsp;&nbsp;2018-03-12&nbsp;-&nbsp;2018-04-08&nbsp;&nbsp;(4课时)
						</p>
						<div class="course-info-teachers text-left ">
							<div class="course-info-teacher-item text-center ">
								<img src="images/teacher/gaojin.png" width="70px" height="71px">
								<p class="text-center ">
									<span>高境</span>
								</p>
							</div>
							<div class="course-info-teacher-item text-center ">
								<img src="images/teacher/xuming.jpg" width="70px" height="71px">
								<p class="text-center ">
									<span>徐铭</span>
								</p>
							</div>
							<div class="course-info-teacher-item text-center ">
								<img src="images/teacher/lihonghe.png" width="70px"
									height="71px">
								<p class="text-center ">
									<span>李洪鹤</span>
								</p>
							</div>
						</div>
						<div class="course-info-split "></div>
						<div class="course-info-students ">
							<div class="course-info-student-number ">
								<p class="show-false student-str">0人购买</p>
								<p class="show-false">
									<span></span>
								</p>
							</div>
							<div class="course-info-price show-commen ">
								¥&nbsp; <span>199.0</span>
							</div>
						</div>
					</div>		 -->

				</div>
			</div>
			<div id="truman-body-loading" data="15">
				<div class="spinner ">
					<div class="rect1 "></div>
					<div class="rect2 "></div>
					<div class="rect3 "></div>
					<div class="rect4 "></div>
					<div class="rect5 "></div>
				</div>
			</div>
			<div id="truman-body-nomore">
				<p class="text-center ">没有更多了</p>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	<script src="js/mycourse.js"></script>
	
</body>
</html>
