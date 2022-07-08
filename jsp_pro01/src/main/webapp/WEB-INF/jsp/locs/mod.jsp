<%@page import="locs.model.LocsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 수정</title>
</head>
<body>
	<h1>지역 수정</h1>
	<%
		if(request.getParameter("errorMsg") != null) {
	%>
		<script type="text/javascript">
			alert("<%=request.getAttribute("errorMsg") %>");
		</script>
	<%
		}
	%>
	<%
		LocsDTO data = (LocsDTO) request.getAttribute("data");
	%>
	<form action="./mod" method="post">
		<input type="hidden" name="locsId" value="<%=data.getLocsId() %>" placeholder="지역 ID" readonly>
		<div>
			<input type="text" name="streetAddress" value="<%=data.getStreetAddress() %>" placeholder="거리 주소">
		</div>
		<div>
			<input type="text" name="postalCode" value="<%=data.getPostalCode() %>" placeholder="우편번호">
		</div>
		<div>
			<input type="text" name="city" value="<%=data.getCity() %>" placeholder="주">
		</div>
		<div>
			<input type="text" name="stateProvince" value="<%=data.getStateProvince() %>" placeholder="도시">
		</div>
		<div>
			<input type="text" name="countryId" value="<%=data.getCountryId() %>" placeholder="국가 ID">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>