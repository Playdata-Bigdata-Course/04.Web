package step01.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost/step01_basic/encore01
@WebServlet("/encore01")
public class Servlet01Method extends HttpServlet {
	//get 방식 요청시 자동 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		//client가 입력한 데이터 획득 - 문자열 간주 <input type = "text" name = "id"><br>
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//접속한 client에게 한글 응답
		//한글 응답이 가능하게 세팅
		//mime type
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(id.equals("SMITH") && pw.equals("11")) {
			//forward
//			response.sendRedirect("success");
			request.getRequestDispatcher("success").forward(request, response);
		}else {
			//redirect
			response.sendRedirect("fail");
//			request.getRequestDispatcher("fail").forward(request, response);
		}
	}
	//post 방식 요청시 자동 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//client가 입력한 데이터 획득 - 문자열 간주 <input type = "text" name = "id"><br>
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//접속한 client에게 한글 응답
		//한글 응답이 가능하게 세팅
		//mime type
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(id.equals("SMITH") && pw.equals("11")) {
			//forward
			response.sendRedirect("success");
//			request.getRequestDispatcher("success").forward(request, response);
		}else {
			//redirect
//			response.sendRedirect("fail");
			request.getRequestDispatcher("fail").forward(request, response);
		}
	}
}
