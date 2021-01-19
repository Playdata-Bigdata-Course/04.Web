package step02.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/step01_basic/api/lifecycle
//http://localhost/step01_basic/api/lifecyle
@WebServlet("/api/lifecyle")
public class ServletAPI1lifecycle extends HttpServlet{
	//최초의 client가 요청시에 단 한번 자동 생성
	public ServletAPI1lifecycle() {  
		System.out.println("ServletAPI1lifecycle 난 생성자");
	}
	//최초의 client가 요청시에 생성자 실행 직후에 단 한번 실행
	//모든 user들이 공유하는 자원 초기화 로직이 있을 경우 재정의
	public void init() {
		System.out.println("init()");
	}
	
	//client가 요청하는 수 만큼 실행 - service 메소드
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("doGet() ***");
	}
	
	//수정된 servlet이 서버에 배포가되면 web server가 변경사항 감지 후에 
	//기존 객체 메모리에서 해제시 자동 호출
	//모든 user들이 공유했던 자원 해제시 재정의
	public void destroy() {
		System.out.println("destroy()");
	}
}