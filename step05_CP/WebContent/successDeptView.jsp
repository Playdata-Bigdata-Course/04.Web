<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dept.model.domain.DeptDTO, java.util.ArrayList"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SuccessDeptView.jsp</title>
</head>
<body>
	
	
	<c:forEach items="${sessionScope.all}" var="data">
	  ${data.deptno}-${data.dname}-${data.loc}<br>	
	</c:forEach>
</body>
</html>