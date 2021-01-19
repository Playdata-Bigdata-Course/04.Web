<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp02_actionView.jsp</title>
</head>
<body>
	${pageContext.request.contextPath}
	<br><br><br>
	<%
	System.out.println("jsp02_actionView.jsp");
	
		String msg = request.getParameter("msg");  //?msg=값
		out.println(msg);
	%>
	
	<%--? 버튼으로 jsp01_scripting.jsp 로 이동 되는 코드 추가하기 --%>
	<button onclick="${pageContext.request.contextPath}location.href='jsp01_scripting.jsp'">01 jsp로 이동</button>
</body>
</html>