package step02.datapublic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/B")
public class B extends HttpServlet {
	//A에서 저장된 데이터 서버 콘솔에 출력
	//C로 redirect로 이동
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- B 출력 ---");
		
		System.out.println(request.getAttribute("id")); //null
		System.out.println(request.getAttribute("name")); //null
		
		System.out.println(request.getAttribute("newData")); //art
		
		//getParameter() : web query string값만 반환
		//getAttribute() : setAttribute()로 저장된 데이터만 반환 
		System.out.println(request.getParameter("id")); //test 
		System.out.println(request.getParameter("name")); //김혜경
		
		
		System.out.println("*** session ***");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("idS"));
		System.out.println(session.getAttribute("nameS"));
		System.out.println(session.getAttribute("newData"));
		System.out.println(session.getAttribute("playdata")); //null
		
		System.out.println("*** context ***");
		ServletContext context = getServletContext(); 
		System.out.println(context.getAttribute("idC"));
		System.out.println(context.getAttribute("nameC"));
		System.out.println(context.getAttribute("newData"));
		
		response.sendRedirect("C");
	}

}