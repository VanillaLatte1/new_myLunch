package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dao.MenuDaoImpl;
import dto.Menu;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글을 받기 위해 인코딩 설정 (jsp에서 한글 깨질 때 필수)
		request.setCharacterEncoding("utf-8"); 
		//insert.jsp에서 전달된 데이터를 받기
		String menu = request.getParameter("menu");
		String price = request.getParameter("price");
		String img = request.getParameter("img");
		
		//확인
		System.out.println(menu);
		System.out.println(price);
		System.out.println(img);
		
		//DB에 넣기 전에 dto에 받은 데이터 세팅
		Menu dto = new Menu();
		dto.setMenu(menu);
		dto.setPrice(Integer.parseInt(price));
		dto.setImg(img);
		
		// DB에 데이터 넣기
		// 다형성의 예제 / 자식인 impl을 부모인 dao에서 생성해서 사용할 수 있다
		MenuDao dao = new MenuDaoImpl();
		dao.insert(dto);
		
		// 페이지 이동
		//response.sendRedirect("/insert_ok.menu");
		
		//자바 스크립트를 이용해서 알림 띄우고 페이지 이동
		// 브라우저로 보내기 전에 한글 설정
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('정상적으로 등록되었습니다.'); location.href='/insert.menu';</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
