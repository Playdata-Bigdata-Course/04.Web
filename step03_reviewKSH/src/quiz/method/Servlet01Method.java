package quiz.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/01")
public class Servlet01Method extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		//client가 입력한 데이터 획득 - 문자열 간주 <input type = "text" name = "id"><br>
		String value = request.getParameter("age");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(value.equals("30")) {
			//forward
			request.getRequestDispatcher("true").forward(request, response);
		}else {
			//redirect
			response.sendRedirect("false");
		}
	}
	//post 방식 요청시 자동 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
	}

}
