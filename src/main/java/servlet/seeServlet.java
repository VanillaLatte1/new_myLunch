package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dao.MenuDaoImpl;
import dto.Menu;

/**
 * Servlet implementation class seeServlet
 */
@WebServlet("/seeServlet")
public class seeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu 데이터를 여기서 가져오자
		MenuDao dao = new MenuDaoImpl();
		List<Menu> list = dao.selectAll();		//menu 테이블 전체 데이터 가져오기
		request.setAttribute("menuList", list);	//윗 줄에서의 전체 menu가 담긴 리스트를 "menulist"라는 이름으로 담는다
		RequestDispatcher dis = request.getRequestDispatcher("/see.jsp");		//리스트를 담은 "menulist"를 see.jsp로 보낸다
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
