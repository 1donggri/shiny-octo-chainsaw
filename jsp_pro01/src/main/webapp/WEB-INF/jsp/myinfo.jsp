<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome JSP/Servlet</title>
	<%@ include file="./module/head.jsp" %>
</head>
<body>
	<%@ include file="./module/navigation.jsp" %>
	<section class="container">
		<form class="small-form" action="./login" method="post">
			<div class="picture">
				<img alt="img" src="img.png">
				<p>picture</p>
			</div>
			<div class="input-form">
				<label class="input-label">ID</label>
				<input type="text" class="input-text" name="empId" value="">
			</div>
			<div class="input-form">
				<label class="input-label">이름</label>
				<input type="text" class="input-text" name="empName" value="">
			</div>
			<div class="input-form">
				<label class="input-label">직급</label>
				<select class="select-form" name="jobId">
					<c:forEach items="${jobList}" var="empDto">
						<c:choose>
							<c:when test="${empDto.jobId == param.jobId}">
								<option value="${empDto.jobId}" selected>
									[${empDto.jobId}] ${empDto.jobId}
								</option>
							</c:when>
							<c:otherwise>
								<option value="${empDto.jobId}">
									[${empDto.jobId}] ${empDto.jobId}
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="input-form">
				<label class="input-label">부서</label>
				<select class="select-form" name="deptId">
					<c:forEach items="${deptList}" var="deptDto">
						<c:choose>
							<c:when test="${deptDto.deptId == param.deptId}">
								<option value="${deptDto.deptId}" selected>
									[${deptDto.deptId}] ${deptDto.deptName}
								</option>
							</c:when>
							<c:otherwise>
								<option value="${deptDto.deptId}">
									[${deptDto.deptId}] ${deptDto.deptName}
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="input-form wide">
				<label class="input-label">이메일</label>
				<input type="text" class="input-text" name="email" value="">
			</div>
			<div class="input-form">
				<label class="input-label">입사일</label>
				<input type="date" class="input-text" name="hireDate" value="">
			</div>
			<div class="input-form">
				<label class="input-label">전화번호</label>
				<input type="text" class="input-text" name="phoneNumber" value="">
			</div>
			<div class="input-form">
				<label class="input-label">급여액</label>
				<input type="text" class="input-text" name="salary" value="">
			</div>
			<div class="input-form">
				<label class="input-label">커미션</label>
				<input type="text" class="input-text" name="commissionPct" value="">
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
			</div>
		</form>
	</section>
</body>
</html>