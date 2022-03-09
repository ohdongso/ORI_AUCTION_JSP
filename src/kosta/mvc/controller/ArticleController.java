package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dto.ArticleDTO;
import kosta.mvc.service.ArticleService;
import kosta.mvc.service.ArticleServiceImpl;

public class ArticleController implements Controller {
	private ArticleService articleService = new ArticleServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		return null;
	}
	
	/**
	 * 전체검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNo = request.getParameter("pageNo");
		  if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		
		//서비스 호출
		List<ArticleDTO> list = articleService.selectAll(Integer.parseInt(pageNo));
		
		request.setAttribute("articleList", list);//${requestScope.boardlist}사용가능
		request.setAttribute("pageNo", pageNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msArticle/list.jsp");
		
		return mv;
	}
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String atcTitle = request.getParameter("atcTitle");
		String atcContents = request.getParameter("atcContents");
		
		String atcUrl = request.getParameter("atcUrl");
		
		ArticleDTO article = new ArticleDTO(0,atcTitle, atcContents, null, atcUrl);
		articleService.insert(article);
		return new ModelAndView("front?key=article&methodName=selectAll", true);
	}
	
	/**
	 * 수정완료하기
	 **/ 
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int atcCode = Integer.parseInt(request.getParameter("atcCode"));
		String atcTitle = request.getParameter("atcTitle");
		String atcContents = request.getParameter("atcContents");
		String atcUrl = request.getParameter("atcUrl");
	
	
		ArticleDTO article = new ArticleDTO(atcCode, atcTitle, atcContents, null, atcUrl);
		
		
		articleService.update(article);
		
		
		
	
		article = articleService.selectByAtcCode(atcCode);
		
		
		request.setAttribute("article", article);
		
		
		return new ModelAndView("front?key=article&methodName=selectAll", true);
	}
	
	/**
	 * 수정form
	 **/ 
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int atcCode = Integer.parseInt(request.getParameter("atcCode"));
		
		
	
		ArticleDTO article = articleService.selectByAtcCode(atcCode);
		
		
		request.setAttribute("article", article);
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("msArticle/update.jsp");
		return mv;
	}
	
	/**
	 * 삭제하기
	 **/ 
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int atcCode = Integer.parseInt(request.getParameter("atcCode"));
		articleService.delete(atcCode);
		return new ModelAndView("front?key=article&methodName=selectAll", true);
	}
}


























