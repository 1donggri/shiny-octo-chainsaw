<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, locs.model.LocsDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
</head>
<script type="text/javascript">
	window.onload = function() {
		var form = document.forms[0];
		form.addEventListener("submit", formCheck);
	}

	function formCheck(e) {
		if(this.search.value === "") {
			e.preventDefault();
		} else {
			this.submit();
		}
	}
</script>
<body>
	<h1>지역 조회 결과</h1>
	<div>
		<button type="button" onclick="location.href='./locs/add'">추가</button>
	</div>
	<div>
		<form action="./locs" method="get">
			<div>
				<input type="text" name="search">
				<button type="submit">조회</button>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<th>LocsId</th>
			<th>StreetAddress</th>
			<th>PostalCode</th>
			<th>City</th>
			<th>StateProvince</th>
			<th>CountryId</th>
			<th></th>
		</tr>
	<%
		if(request.getAttribute("locsDatas") != null){
			List<LocsDTO> datas = (List<LocsDTO>) request.getAttribute("locsDatas");
			for(LocsDTO data: datas) {
	%>
			<tr>
				<td><%=data.getLocsId() %></td>
				<td><%=data.getStreetAddress() %></td>
				<td><%=data.getPostalCode() %></td>
				<td><%=data.getCity() %></td>
				<td><%=data.getStateProvince() %></td>
				<td><%=data.getCountryId() %></td>
				<td>
					<button type="button" onclick="location.href='./locs/mod?id=<%=data.getLocsId() %>'">수정</button>
					<button type="button" onclick="location.href='./locs/del?id=<%=data.getLocsId() %>'">삭제</button>
				</td>
			</tr>
	<%
			}
		}
	%>
	</table>
</body>
</html>