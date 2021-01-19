package step02.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session1")
public class One extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//id, msg라는 key로 데이터를 상태 유지값으로 사용 
		//세션 기술 적용 따라서 서버 메모리에 저장
		//모든 user가 명확하게 구분되는 각각의 request로 부터 세션 객체 생성
		//접속한  client 시스템에 고유한 랜덤값을 서버가 접속하자마자 전송해 놓은 데이터값 활용
		
		//이 고유한 id값으로 이미 생성된 세션 객체가 서버에 있는지 없는지? web server는확인
		//없다면 생성, 있다면 있는 HttpSession 객체 제공
		HttpSession session = request.getSession();//생성
		System.out.println(session.getId());
		//데이터는  key는 value로 구분해서 저장
		session.setAttribute("name", "유재석");
		session.setAttribute("age", "47");
		
		response.sendRedirect("session2");  //get
	}

}