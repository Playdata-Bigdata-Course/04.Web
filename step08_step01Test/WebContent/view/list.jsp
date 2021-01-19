<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.CustomerVo, java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>모든 고객 보기</title>
</head>  
<body>
<center>
<h3>모든 고객 보기</h3>
<table border="1"  width="70%">
   <tr>
      <td width="20%">id</td>
      <td width="20%">이름</td>
      <td width="40%">이메일 주소</td>
      <td width="20%">탈퇴</td>
   </tr>   
   <c:forEach var="v" items="${sessionScope.allList}">
    <tr>
       <td>${v.id}</td><td>${v.name}</td><td>${v.email}</td>
       <td>
          <button onclick="location.href='CustomerServlet?command=delete&id=${v.id}'">탈퇴하기</button>
       </td>
    </tr>
   </c:forEach>
</table>
<p>
<a href="index.html">메인으로 이동</a>
</center>
</body>
</html>
