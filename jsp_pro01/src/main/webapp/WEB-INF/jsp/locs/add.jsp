<%@page import="locs.model.LocsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 추가</title>
</head>
<body>
	<h1>지역 추가</h1>
	<%
		String locsId = "";
		String streetAddress = "";
		String postalCode = "";
		String stateProvince = "";
		String city = "";
		String countryId = "";
		
		if(request.getAttribute("error") != null) {
			LocsDTO dto = (LocsDTO) request.getAttribute("error");
			locsId = dto.getLocsId() == -1 ? "" : String.valueOf(dto.getLocsId());
			streetAddress = dto.getStreetAddress();
			postalCode = dto.getPostalCode();
			stateProvince = dto.getStateProvince();
			city = dto.getCity();
			countryId = dto.getCountryId().equals("-1") ? "" : String.valueOf(dto.getCountryId());
	%>
		<script type="text/javascript">
			alert("<%=request.getAttribute("errorMsg") %>");
		</script>
	<%
		}
	%>
	<form action="./add" method="post">
		<div>
			<input type="text" name="locsId" value="<%=locsId %>" placeholder="지역 ID">
		</div>
		<div>
			<input type="text" name="streetAddress" value="<%=streetAddress %>" placeholder="거리 주소">
		</div>
		<div>
			<input type="text" name="postalCode" value="<%=postalCode %>" placeholder="우편번호">
		</div>
		<div>
			<input type="text" name="stateProvince" value="<%=stateProvince %>" placeholder="주">
		</div>
		<div>
			<input type="text" name="city" value="<%=city %>" placeholder="도시">
		</div>
		<div>
			<input type="text" name="countryId" value="<%=countryId %>" placeholder="국가 ID">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>