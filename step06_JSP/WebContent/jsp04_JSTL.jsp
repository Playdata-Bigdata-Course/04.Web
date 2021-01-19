<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp04_JSTL.jsp</title>
</head>
<body>
	<h3>1. if tag 학습</h3>
	<c:if test="${2==2 }">
		1. if 조건식이 test라는 속성, EL tag로 조건식 표현<br>
		2. 조건식이 true인 경우만 실행되는 블록
	</c:if>
  <br><hr><br>
  
  <h3>2. if 조건식에 자바 데이터 비교</h3>
	<% request.setAttribute("rData", "String"); %>
	<%-- request에 string 문자열 저장여부 확인 --%>
	 <c:if test="${requestScope.rData =='String'}">
		1. if 조건식이 test라는 속성, EL tag로 조건식 표현<br>
		2. 조건식이 true인 경우만 실행되는 블록
	</c:if>
  <br><hr><br>
  
   <h3>3. if 조건식에 자바 데이터 존재 여부 비교</h3>
	<c:if test="${requestScope.sData == null }">
		3-1 해당 데이터가 있는 경우만 출력 <br>
	</c:if>
	
	<c:if test="${empty requestScope.sData}">
		3-2 해당 데이터가 있는 경우엔 empty 연산자 사용 검증 가능  <br>
	</c:if>
	
	<c:if test="${not empty requestScope.sData}">
		3-3 해당 데이터가 null이 아닌 경우에만 출력  <br>
	</c:if>
  <br><hr><br>
  
   <h3>4. 다중 조건식 : if tag만으로 다중 조건식 적용 불가, else 표현식이 없음 </h3>
   <c:choose>
   		<c:when test="${2==3 }">
   		1<br>
   		</c:when>
   		<c:when test="${2==2 }">
   		2<br>
   		</c:when>
   		<c:otherwise>
   		3
   		</c:otherwise>
   </c:choose>
</body>
</html>