<%@ page import="model.domain.People, java.util.ArrayList, java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp03_EL.jsp</title>
</head>
<body>
	EL tag학습
	<br><hr><br>

	<table border="1">
	
		<tr><th>non-el</th><th>el</th></tr>

		<tr><td>2+3</td><td>${2+3}</td></tr>
		<tr><td>3==3</td><td>${3==3}</td></tr>
		<tr><td>"a"=="a"</td><td>${"a"=="a"}</td></tr>
	
	</table>
	
	<br><hr><br>
	<%-- servlet에서 이미 요청 객체 또는 세션 개게에 데이터를 저장하고 출력등의 로직 지시했다 가정 --%>
	<%	//EL 학습을 위한 test 데이터 구성
		//setAttribute() - 데이터 저장/getAttribute() - 데이터 반환
		
		//1단계 - 단순 문자열저장
		//2단계 - DTO 저장
		//3단계 - ArrayList<~DTO> & 배열
		//4단계 - Map에 ArrayList 저장
		request.setAttribute("rData1", "혜경");
		session.setAttribute("sData1", new People("혜경씨", 46));
		
		ArrayList<People> all = new ArrayList<People>();
		all.add(new People("다영", 26));
		all.add(new People("연식", 26));
		all.add(new People("민권", 26));
		
		
		application.setAttribute("aData1", all);
		
		//?
		HashMap<String, ArrayList<People>> all2 = new HashMap<>();
		all2.put("one", all);
		session.setAttribute("sData2", all2);
		
		/*
		sessionScope.sdata2.one[1].name
		sessionScope : session
		sData2 : HashMap
		one : ArrayList<People>
		[1] : new People("연식", 26)
		name : People의 name을 getName()
		*/
	%>
	2. 요청과 세션과 컨텍스트에 저장된 데이터들 화면에 출력하는 방법 <br>
		1. 요청에 저장된 데이터 출력 : ${requestScope.rData1} <br>
		2. 세션에 저장된 데이터 중 이름만 출력 : ${sessionScope.sData1.name }<br> <!-- getName() -->
		3. context에 저장된 데이터 중 다영씨 이름만 출력 :${applicationScope.aData1[0].name }<br>
		4. context에 저장된 데이터 중 민권씨 나이만 출력 :${applicationScope.aData1[0].age }<br>
		5. 세션에 저장된 sData2에 맵핑된 데이터 중 연식 이름만 출력 : ${sessionScope.sData2.one[1].name }<br>
		
</body>
</html>