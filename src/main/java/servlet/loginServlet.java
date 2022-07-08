package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TbuserDao;
import dao.TbuserDaoImpl;
import dto.tbUser;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 들어오면 login페이지를 보여주고
		RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 원래는 doget으로 보냈는데
		// post 데이터를 가지고 들어오면 login 처리
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println(userId);
		System.out.println(userPw);

		TbuserDao dao = new TbuserDaoImpl();
		tbUser dto = dao.selectLogin(userId, userPw);
		
		//만약에 tbUser가 null이 아니면
		if(dto == null) {
			// 로그인 실패 / 로그인 실패 메세지를 보내고 login.menu
			response.sendRedirect("/loginFail.jsp");
		}
		else {
			//세션 받기 / 세션은 페이지를 이동해도 데이터가 저장되어있다
			HttpSession session = request.getSession();
			// 로그인한 유저 정보 저장
			session.setAttribute("user", dto);
			// 로그인 성공 / main으로 이동 / 메뉴 입력 버튼 보이고 login => logout으로 변경
			response.sendRedirect("/");
		}
		
	}

}
