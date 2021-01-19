<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp01_scripting.jsp</title>
</head>
<body>
	<%--
		1. 변수, 메소드 구현
		2. 출력 
	 --%>
	 <%-- html 주석 
		1. 변수, 메소드 구현
		2. 출력 
	 --%>
	 <% System.out.println("jsp01_scripting.jsp"); %>
	 <%!
	
	 	String id = "tester"; 
		 public String getId(){
	 		return id;
	 		
	 	}
	 %>
	 1. <%= id %> <br>
	 2. <%= getId() %> <br>
	 3. <% out.println(id); %>
	
</body>
</html>