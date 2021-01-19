package dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDAO;
import dept.model.domain.DeptDTO;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	/*
	 * id/pw 가 유효한 경우 select 요청 후 결과 값을 세션에 저장해서 redirect로 View 서블릿으로 출력위임
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String url = "SuccessView.jsp";

		if (id.equals("SMITH") && pw.equals("11")) {
			try {
				ArrayList<DeptDTO> all = DeptDAO.deptAll();

				if (all.size() != 0) {
					request.getSession().setAttribute("all", all);
//					url = "successDeptView";
					
					url = "successDeptView.jsp"; //html, css, javascript, jsptag
				} else {
					request.setAttribute("message", "현 시점 에선 부서 정보가 하나도 없습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				url = "FailView.jsp";
				request.setAttribute("errorMsg", "죄송합니다 잠시후에 재 요청해 주세요");
			}
		} else {
			request.setAttribute("message", "id or pw 재 확인 부탁드려요");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
