<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
<h3>회원가입</h3>
	<br>
	<!-- write Form  -->

	<form action="../CustomerServlet" method="post">

		<!-- page 구분을 위한 hidden tag 설정입니다  controller인 servlet 클래스에서 활용될 데이타 값입니다. -->


		<table border="1" cellspacing="1" width="60%">
			<tr>
				<td width=30% align=center>사용자 아이디</td>
				<td width=70%><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width=30% align=center>비밀번호</td>
				<td width=70%><input type="password" name="password"></td>
			</tr>

			<tr>
				<td width=30% align=center>이름</td>
				<td width=70%><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width=30% align=center>이메일 주소</td>
				<td width=70%><input type="email" name="email" size="50">
				</td>
			</tr>
		</table>
		<br>
		<br> <input type="hidden" name="command" value="insert">
		<input type="submit" value="회원가입">&nbsp; 
		<input type="reset" value="취소">&nbsp;

		<!-- 다음은 버튼 클릭만으로  index.html파일로 이동 가능한 단순 문법입니다. -->

		<input type="button" value="메인으로 이동"
			Onclick="location.href='../index.html'">
	</form>
</body>
</html>