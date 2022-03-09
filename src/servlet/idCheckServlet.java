package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dao.sy.MemberDAO;
import kosta.mvc.dao.sy.MemberDAOImpl;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("/idCheck")
public class idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		
		MemberDAO memberDAO = new MemberDAOImpl();
		boolean result = memberDAO.idCheck(id);
		
		PrintWriter out = response.getWriter();
		System.out.println("Servlet In");
		if(result)
			out.println("중복입니다.");
		else
			out.println("사용가능합니다.");
	}

}



		
		

