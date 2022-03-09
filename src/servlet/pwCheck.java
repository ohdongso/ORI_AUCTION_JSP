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
@WebServlet("/pwCheck")
public class pwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String pw = request.getParameter("pw");
		String pwc = request.getParameter("pwc");
		
		boolean result=false;
		
		if(pw.equals(pwc))result=true;
		
		PrintWriter out = response.getWriter();
		System.out.println("Servlet In");
		if(result) {
			out.println("일치");
		}else {
			out.println("불일치");
		}
		
	}

}



		
		

