package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.menu")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("hello world").append(request.getContextPath());
		
		//브라우저에서 서버에게 요청한 URI
		String uri = request.getRequestURI();
		System.out.println(uri);
		//브라우저에서 서버에게 요청한 URL
		//URL은 반환값이 StringBuffer로 되어있어서 같은 타입으로 맞춰줌
		StringBuffer url = request.getRequestURL();
		System.out.println(url.toString());
		
		//문자열 자르기 (insert.menu에서 .menu를 생략하고 비교하고 싶어서) / 구분자를 . 으로 쓸 때는 \\을 붙여줄 것
		String [] uriArr = uri.split("\\.");
		System.out.println(uriArr[0]);
		
		String site = "";
		
		//uri 요청이 insert면 insert.jsp로 이동
		if(uriArr[0].equals("/insert")) {
			System.out.println("insert.jsp로 이동");
			//서블릿 페이지 이동 2가지 방법
			
			//주소를 바꾸지 않고 내용만 바뀐다 / 이동할 페이지로 값을 가져갈 수 있다 (주소 : http://localhost:8080/insert.menu)
			//값을 가져가야 하는 상황일 때 / 데이터 삽입, 삭제, 수정 등
			//RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
			//rd.forward(request, response);
			
			//주소는 바뀌지만 값을 가져갈 수 없다 (주소 : http://localhost:8080/insert.jsp)
			//그냥 페이지 이동만 해도 될 때 / naver 등의 사이트 이동 
			//response.sendRedirect("/insert.jsp");
			site = "/insert.jsp";
		}
		else if(uriArr[0].equals("/see")) {
			System.out.println("see.jsp로 이동");
//			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
//			rd.forward(request, response);
			site = "/see.jsp";
		}
		else if(uriArr[0].equals("/best")) {
			System.out.println("best.jsp로 이동");
//			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
//			rd.forward(request, response);
			site = "/best.jsp";
		}
		else {
			site = "/404.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(site);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
