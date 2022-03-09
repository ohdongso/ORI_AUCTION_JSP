package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dto.FaqDTO;
import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.service.FaqService;
import kosta.mvc.service.FaqServiceImpl;

public class FaqController implements Controller {
	private FaqService faqService = new FaqServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<FaqDTO> list = faqService.selectAll();
		request.setAttribute("faqList", list);//${requestScope.list}사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faq/list.jsp");
		return mv;
	}
	
	public ModelAndView searchByCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		int category = Integer.parseInt(request.getParameter("category"));
		List<FaqDTO> list = faqService.searchByCategory(category);
		request.setAttribute("faqList", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faq/list.jsp");
		return mv;
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		int faqCode = Integer.parseInt(request.getParameter("faqCode"));
		faqService.delete(faqCode);
		
		
		
		List<FaqDTO> list = faqService.selectAll();
		request.setAttribute("faqList", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faq/list.jsp");
		return mv;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String faqTitle = request.getParameter("title");
		int faqCategory = Integer.parseInt(request.getParameter("category"));
		String faqContents = request.getParameter("content");
		
		FaqDTO faq = new FaqDTO(0, faqCategory, faqTitle, faqContents);
		faqService.insert(faq);
		
		List<FaqDTO> list = faqService.selectAll();
		request.setAttribute("faqList", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faq/list.jsp");
		return mv;
	}
}
