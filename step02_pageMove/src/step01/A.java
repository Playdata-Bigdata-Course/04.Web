package step01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/a")
public class A extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is A");
		//A forward라는 기술로 B로 이동
		//요청 a, 응답 a
//		request.getRequestDispatcher("b").forward(request, response);
		
		//A redirect라는 B로 이동
		//요청 a, 응답 b
		response.sendRedirect("b");
	}

}
