<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

b를 포함 전 

<br><hr><br>

b 포함 후 
<!-- 상대 경로로 jsp를 포함 
http://로직 직접적인 page 설정 불가 
page는 jsp를 의미
동일한 프로젝트 내부의 jsp & servlet & html등은 하나의 project 맞음 
다른 project와의 호환은 servlet & jsp 정책상 자원 활용 불가
단순 link는 가능
jsp는 자바 코드 조작, 데이터 CRUD는 가능
결론 : 타 사이트의 처리 로직 가능한 실행 파일들은 include 불가 즉 보안을 고려한 정책 
 -->
<jsp:include page="/view01/b.jsp"/>

<br><hr><br>





</body>
</html>