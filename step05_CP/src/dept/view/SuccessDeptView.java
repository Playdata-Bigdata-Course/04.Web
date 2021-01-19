package dept.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.domain.DeptDTO;

@WebServlet("/successDeptView")
public class SuccessDeptView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<DeptDTO> all =(ArrayList<DeptDTO>)(request.getSession().getAttribute("all"));
		
		for(DeptDTO dept : all) {
			out.println(dept + "<br>");
		}
	}

}
