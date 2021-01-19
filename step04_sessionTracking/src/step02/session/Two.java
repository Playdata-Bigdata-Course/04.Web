package step02.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class Two extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//이미 존재하는 세션 객체로 부터 데이터 획득해서 출력
		HttpSession session = request.getSession(); //존재하는 세션객체 반환
		out.println(session.getAttribute("name"));
		
		out.println("<button onclick=\"location.href='session3'\">이동</button>");
		//method="post" 없으면 모두다 get
	}
}