package step02.datapublic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/A")
public class A extends HttpServlet {
	/* 요청된 한글 인코딩, 입력된 데이터값 요청객체, 세션객체, context 객체 활용
	 * B로 화면 이동
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		System.out.println(1 + " - 요청 객체의 데이터 : " + id);
		System.out.println(2 + " - 요청 객체의 데이터 : " + name);
		
		//요청 객체는 고유한 user만의 자원, forward로 화면 이동시에만 유지
		request.setAttribute("newData", "art");
		
		//세션 생성 후 세션에 데이터 저장
		//page이동 방식과 무관하게 고유 user만을 위한 자원
		HttpSession session = request.getSession();
		session.setAttribute("idS", id);
		session.setAttribute("nameS", name);
		session.setAttribute("newData", "artSession");
		
		//모든 user에게 공유하는 객체
		ServletContext context = getServletContext();
		context.setAttribute("idC", id);
		context.setAttribute("nameC", name);
		context.setAttribute("newData", "artContext");
		
		request.getRequestDispatcher("B").forward(request, response);
	}

}