
package step01.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class One extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//key와 value 구조로 쿠키 생성
		Cookie id = new Cookie("id", request.getParameter("id"));
		Cookie msg = new Cookie("msg", request.getParameter("hello"));//null
		
		//client 시스템에 잔존 시간 설정 
		id.setMaxAge(60*60*24*365);
		msg.setMaxAge(60*60*24*365);
		
		//client에게 응답
		response.addCookie(id);
		response.addCookie(msg);
		
		response.sendRedirect("encore2");
	}

}