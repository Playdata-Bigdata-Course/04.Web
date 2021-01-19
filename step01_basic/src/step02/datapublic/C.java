package step02.datapublic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/C")
public class C extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("--- C  출력 ---");
	
	System.out.println(request.getAttribute("id"));
	System.out.println(request.getAttribute("name"));
	System.out.println(request.getAttribute("newData"));
	
	System.out.println(request.getParameter("id"));
	System.out.println(request.getAttribute("name"));
	System.out.println(request.getAttribute("newData"));
	
	System.out.println("*** session ***");
	HttpSession session = request.getSession();
	System.out.println(session.getAttribute("idS"));
	System.out.println(session.getAttribute("nameS"));
	System.out.println(session.getAttribute("newData"));
	
	System.out.println("*** context ***");
	ServletContext context = request.getServletContext();
	System.out.println(context.getAttribute("idC"));
	System.out.println(context.getAttribute("nameC"));
	System.out.println(context.getAttribute("newData"));
	
	}

}
