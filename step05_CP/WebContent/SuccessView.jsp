<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="dept.model.domain.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>SuccessView.jsp</title>
</head>
<body>
	<%
		System.out.println("���� ��� : " + request.getAttribute("message"));	
	%>

</body>
</html>