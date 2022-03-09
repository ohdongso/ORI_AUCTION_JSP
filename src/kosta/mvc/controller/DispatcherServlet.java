package kosta.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
	public void init() throws ServletException {
		map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		
		try {
			
			Class<?> clz = clzMap.get(key);
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			Controller controller = map.get(key);
			
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response);//Ư�� controller�� �޼ҵ尡 ȣ��ȴ�.
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
