<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보</title>
	<%@ include file="../module/head.jsp" %>
</head>
<script type="text/javascript">
	window.onload = function() {
		var form = document.forms[0];
		form.email.addEventListener("input", enableSaveButton);
		form.phone.addEventListener("input", enableSaveButton);
		
		prevImage.addEventListener("click", function(e){
			btnImage.click();
		});
		
		btnImage.addEventListener("change", showPreview);
	}
	
	function ajaxUploadImage(e) {
		var file = e.target.files[0];
		var fData = new FormData();
		fData.append("uploadImage", file, file.name);
		
		$.ajax({
			type: "post",
			url: "/ajax/imageUpload",
			enctype: "multipart/form-data",
			data: fData,
			processData: false,		// 문자열에는 쓰지 않음
			contentType: false,		
			dataType: "json",
			success: function(data, status){
				prevImage.src = data.loc;
			},
			error: function(data, status) {
				prevImage.src = data.loc;
			}
		});
	}
	
	function showPreview(e) {
		var file = e.target.files[0];
		var imgUrl = URL.createObjectURL(file);
		prevImage.src = imgUrl;
	}

	function enableSaveButton(e) {
		var submit = document.querySelector("button[type='submit']");
		var enable = submit.getAttribute("class").replace("disable", "");
		submit.setAttribute("class", enable);
	}
</script>
<body>
	<%@ include file="../module/navigation.jsp" %>
	<section class="container">
		<c:url var="updateUrl" value="/myinfo"></c:url>
		<form class="large-form" action="${updateUrl}" method="post" enctype="multipart/form-data">
			<div class="img-form left">
				<c:url var="imgUrl" value="/static/img/emp/${imgPath}" />
				<img class="img-360" alt="여기에는 증명 사진이 배치됩니다." src="${imgUrl}">
				<br>
				<input type="file" id="dtnImage" name="uploadImage">
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-100">ID</label>
					<input class="input-text w-auto" type="text" name="empId" value="${sessionScope.loginData.empId}" readonly>
				</div>
				<div class="input-form">
					<label class="input-label w-100">이름</label>
					<input class="input-text w-auto" type="text" name="empName" value="${sessionScope.loginData.empName}">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-100">직급</label>
					<select class="select-form w-auto" name="jobId">
						<c:choose>
							<c:when test="${job.jobId == session.Scope.loginData.jobId}">
								<option value="${job.jobId}" selected>${job.jobName}</option>
							</c:when>
							<c:otherwise>
								<option value="${job.jobId}">${job.jobName}</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<div class="input-form">
					<label class="input-label w-100">부서</label>
					<select class="select-form w-auto" name="deptId">
						<c:choose>
							<c:when test="${dept.deptId == session.Scope.loginData.deptId}">
								<option value="${dept.deptId}" selected>${dept.deptName}</option>
							</c:when>
							<c:otherwise>
								<option value="${dept.deptId}">${dept.deptName}</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-100">이메일</label>
					<input class="input-text w-auto" type="text" name="email" value="${sessionScope.loginData.email}">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<fmt:formatDate var="fmtHireDate" value="${empDetail.hireDate}" dateStyle="long"/>
					<label class="input-label w-100">입사일</label>
					<input class="input-text w-auto" type="text" name="hireDate" value="${empDetail.hireDate}">
				</div>
				<div class="input-form">
					<label class="input-label w-100">전화번호</label>
					<input class="input-text w-auto" type="text" name="phone" value="${empDetail.phone}">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-100">급여액</label>
					<input class="input-text w-auto" type="text" name="salery" value="${empDetail.salary}">
				</div>
				<div class="input-form">
					<fmt:formatNumber var="fmtcommission" value="${empDetail.commission}" type="percent"></fmt:formatNumber>
					<label class="input-label w-100">커미션</label>
					<input class="input-text w-auto" type="text" name="commission" value="${empDetail.commission}">
				</div>
			</div>
			<div class="input-form form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
			</div>
		</form>
	</section>
</body>
</html>