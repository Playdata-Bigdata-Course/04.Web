package step02.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost/step01_basic/api2.do?id=test
@WebServlet("/api2.do")
public class ServletAPI2 extends HttpServlet {
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		System.out.println(request.getContextPath());//step01_basic
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalName());
		System.out.println(request.getLocalPort());
		System.out.println(request.getMethod());//80
		System.out.println(request.getQueryString());//null  -> id=test
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURI());//step01_basic/api2.do
		
	}

}