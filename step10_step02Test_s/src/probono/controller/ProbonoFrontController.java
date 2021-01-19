package probono.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import probono.exception.NotExistException;
import probono.model.ProbonoService;
import probono.model.dto.RecipientDTO;
import probono.model.entity.ActivistEntity;
import probono.model.entity.RecipientEntity;

@WebServlet("/probono")
@Slf4j
public class ProbonoFrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// command pattern
		String command = request.getParameter("command");

		// ?

		try {
			if (command.equals("probonoProjectAll")) {// 모든 probono project 정보 검색
				probonoProjectAll(request, response);
			} else if (command.equals("activistAll")) {// 모든 재능 기부자 검색
				activistAll(request, response);
			} else if (command.equals("activist")) {// 특정 재능 기부자 정보 검색
				activist(request, response);
			} else if (command.equals("activistInsert")) {// 재능 기부자 추가 등록
				activistInsert(request, response);
			} else if (command.equals("activistUpdateReq")) {// 재능 기부자 정보 수정요청
				activistUpdateReq(request, response);
			} else if (command.equals("activistUpdate")) {// 재능 기부자 정보 수정
				activistUpdate(request, response);
			} else if (command.equals("activistDelete")) {// 재능 기부자 탈퇴[삭제]
				activistDelete(request, response);
			} else if (command.equals("recipientAll")) {// 모든 재능 수혜자 검색
				recipientAll(request, response);
			} else if (command.equals("recipient")) {// 특정 재능 수혜자 정보 검색
				recipient(request, response);
			} else if (command.equals("recipientInsert")) {// 특정 재능 수혜자 정보 검색
				recipientInsert(request, response);
			} else if (command.equals("recipientDelete")) {// 재능 기부자 탈퇴[삭제]
				recipientDelete(request, response);
			}
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	// 모든 ProbonoProject 검색 메소드
	public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("probonoProjectAll", ProbonoService.getAllProbonoProjects());
			request.getSession().setAttribute("successMsg", "모든 프로젝트 검색 완료");
			url = "probonoProjectList.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			log.warn("모든 프로젝트 검색 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 모든 재능 기부자 검색 - 검색된 데이터 출력 화면[activistList.jsp]
	public void activistAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("activistAll", ProbonoService.getAllActivists());
			request.getSession().setAttribute("successMsg", "모든 재능 기부자 검색");

			url = "activistList.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
			log.warn("기부자 검색 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 재능 기부자 검색
	public void activist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("activist",
					ProbonoService.getActivist(request.getParameter("activistId")));
			request.getSession().setAttribute("successMsg", "재능 기부자 검색");
			url = "activistDetail.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			log.warn("기부자 검색 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 재능 기부자 가입 메소드
	protected void activistInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String major = request.getParameter("major");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		ActivistEntity activist = new ActivistEntity(id, name, pw, major);
		if (id != null && id.length() != 0 && name != null) {
			request.getSession().setAttribute("errorMsg", "빈칸이 허용되지 않습니다.");
		}
		try {
			boolean result = ProbonoService.addActivist(activist);
			if (result) {
				request.getSession().setAttribute("activist", activist);
				request.getSession().setAttribute("successMsg", "가입 완료");
				url = "activistDetail.jsp";
			} else {
				request.getSession().setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			log.warn("기부자 생성실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 재능 기부자 수정 요구
	public void activistUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("activist",
					ProbonoService.getActivist(request.getParameter("activistId")));
			request.getSession().setAttribute("successMsg", "수정 완료");
			url = "activistUpdate.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			log.warn("기부자 수정요구 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 재능 기부자 수정 - 상세정보 확인 jsp[activistDetail.jsp]
	public void activistUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		String id = request.getParameter("activistId");
		String major = request.getParameter("major");

		try {
			ProbonoService.updateActivist(id, major);
			request.getSession().setAttribute("activist",
					ProbonoService.getActivist(request.getParameter("activistId")));
			request.getSession().setAttribute("successMsg", id + "재능 기부자 수정");
			url = "activistDetail.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("errMSg", e.getMessage());
			e.printStackTrace();
			log.warn("기부자 수정 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

	// ???
	// 재능 기부자 삭제
	public void activistDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		String id = request.getParameter("activistId");

		try {
			ProbonoService.deleteActivist(id);
			request.getSession().setAttribute("activistAll", ProbonoService.getAllActivists());
			request.getSession().setAttribute("successMsg", id + "재능 기부자 삭제");
			url = "activistList.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("errMSg", e.getMessage());
			e.printStackTrace();
			log.warn("기부자 삭제 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void recipientAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("recipientAll", ProbonoService.getAllRecipients());
			url = "recipientList.jsp";
		} catch (SQLException e) {
			request.getSession().setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void recipient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("recipient",
					ProbonoService.getRecipient(request.getParameter("receiveId")));
			url = "recipientDetail.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void recipientInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String receiveContent = request.getParameter("receiveContent");
		RecipientEntity recipient = new RecipientEntity(id, name, pw, receiveContent);
		try {
			boolean result = ProbonoService.addRecipient(recipient);
			if (result) {
				request.getSession().setAttribute("recipient", recipient);
				request.getSession().setAttribute("successMsg", "가입 완료");
				url = "recipientDetail.jsp";
			} else {
				request.getSession().setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void recipientDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		String id = request.getParameter("receiveId");

		try {
			ProbonoService.deleteRecipient(id);
			request.getSession().setAttribute("recipientAll", ProbonoService.getAllRecipients());
			url = "recipientList.jsp";
		} catch (SQLException e) {
			request.getSession().setAttribute("errMSg", e.getMessage());
			e.printStackTrace();
		} catch (NotExistException e) {
			request.getSession().setAttribute("errMSg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
