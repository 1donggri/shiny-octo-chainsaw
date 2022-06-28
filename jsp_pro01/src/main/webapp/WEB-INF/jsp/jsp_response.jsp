<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP/Servlet - Response 객체</title>
</head>
<body>
	<h1>JSP - Response 객체</h1>
	<h2>sendRedirect(String url)</h2>
	<%
		// response.sendRedirect("./");
	%>
	<p>
		클라이언트에게 다른 주소로 재요청을 하게 만들기 위해 사용하는 기능<br>
		HTTP 상태 코드 302
	</p>
	<hr>
	<h2>setStatus(int stateCode)</h2>
	<%
		// response.setStatus(HttpServletResponse.SC_ACCEPTED);
		// response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	%>
	<p></p>
	<hr>
	<h2>setError(int stateCode)</h2>
	<p></p>
	<%
		// response.sendError(HttpServletResponse.SC_NOT_FOUND);
		// response.sendError(HttpServletResponse.SC_NOT_FOUND, "잘못된 URL 주소로 요청 하였습니다.");
	%>
	<hr>
	<h2>setContentType(String mimeType)</h2>
	<p></p>
	<%
		// response.setContentType("text/javascript");
	%>
	<hr>
</body>
</html>