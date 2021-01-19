<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ page import="model.CustomerVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html> 
<head>
<title>회원정보 보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

	<h3>개인 회원 정보 보기</h3>
	<br>
	 <form action="CustomerServlet" method="post">
	  
	  <table border="1" cellspacing="1" width="60%">
		  <tr>
			<td width=30%>사용자 아이디</td>
			<td width=70%>
			  ${sessionScope.cvo.id}
			</td> 
		  </tr>
		  <tr>
			<td width="30%">비밀번호</td>
			<td width="70%">
			 	${sessionScope.cvo.password}			
			</td>
		  </tr>
		  <tr>
			<td width="30%">이름</td>
			<td width="70%">
				${sessionScope.cvo.name}
			</td>
		  </tr>
		  <tr>
			<td width="30%">이메일 주소</td>
			<td width="70%">
			   ${sessionScope.cvo.email}
			</td>
		  </tr>		  
	  </table>	
	  <br><br>	  
		<input type="button" value="update"	Onclick="location.href='crud/update.jsp'">&nbsp;
		<input type="submit" value="allView">
		<input type="hidden" name="command" value="allView">
	 </form>

</body>
</html>
