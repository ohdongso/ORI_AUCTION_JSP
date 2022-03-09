package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.dto.ReviewBoardReplyDTO;
import kosta.mvc.dto.ServiceBoardDTO;
import kosta.mvc.dto.ServiceBoardReplyDTO;
import kosta.mvc.service.ServiceBoardReplyService;
import kosta.mvc.service.ServiceBoardReplyServiceImpl;
import kosta.mvc.service.ServiceBoardService;
import kosta.mvc.service.ServiceBoardServiceImpl;

public class ServiceBoardController implements Controller {
	private ServiceBoardService serviceBoardService = new ServiceBoardServiceImpl();
	private ServiceBoardReplyService serviceBoardReplyService = new ServiceBoardReplyServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 1 : 1문의 게시판 조회	
	 *     -전체 조회  : parameter로 전송되는 데이터 없음 
	 *     -카테고리 검색 : category
	 *     -키워드로 검색 : 검색필드와 검색단어 
	 * 
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String category = request.getParameter("category");
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		
		List<ServiceBoardDTO> list =null;
		if(category!=null && !category.equals("")) {
			list = serviceBoardService.searchByServiceBoardCategory(Integer.parseInt(category));
		}else if(keyWord!=null && !keyWord.equals("")) {
			 list = serviceBoardService.searchByServiceBoardKeyField(keyField, keyWord);
		}else {
			list = serviceBoardService.selectAll();
		}
		
		
		request.setAttribute("serviceBoardList", list);//${requestScope.serviceBoardList}사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serIndex.jsp");
		return mv;
	}
	
	/**
	 * 등록하기 
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serviceBoardTitle = request.getParameter("serviceBoardTitle");
		String serviceBoardContent = request.getParameter("serviceBoardContent");
		String id = (String)request.getSession().getAttribute("loginUser");
		int serviceBoardCategory= Integer.parseInt(request.getParameter("serviceBoardCategory"));
		
		
		ServiceBoardDTO serviceBoardDTO = new ServiceBoardDTO(0, id, serviceBoardTitle, serviceBoardContent, serviceBoardCategory, null, 0);
		serviceBoardService.insert(serviceBoardDTO);
		
		return new ModelAndView("front?key=sb&methodName=selectAll", true);
	}
	
	
	
	
	
	
	public ModelAndView selectByServiceBoardCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int serviceBoardCode = Integer.parseInt(request.getParameter("serviceBoardCode"));
		
		ServiceBoardDTO serviceBoardDTO =  serviceBoardService.selectByServiceBoardCode(serviceBoardCode);
		request.setAttribute("serviceBoardDTO", serviceBoardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serRead.jsp");
		
		return mv;
	}
	
	public ModelAndView searchByServiceBoardKeyField(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serviceBoardKeyField = request.getParameter("serviceBoardKeyField");
		String serviceBoardKeyword = request.getParameter("serviceBoardKeyword");
		List<ServiceBoardDTO> list =  serviceBoardService.searchByServiceBoardKeyField(serviceBoardKeyField, serviceBoardKeyword);
		request.setAttribute("serviceBoardList", list);//${requestScope.list}사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serIndex.jsp");
		return mv;
	}

	
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String serviceBoardTitle = request.getParameter("serviceBoardTitle");
		String serviceBoardContent = request.getParameter("serviceBoardContent");
		int serviceBoardCategory = Integer.parseInt(request.getParameter("serviceBoardCategory"));
		int serviceBoardCode = Integer.parseInt(request.getParameter("serviceBoardCode"));
		System.out.println(serviceBoardCategory);
		System.out.println(serviceBoardCode);
		String id = request.getParameter("id");
		
		ServiceBoardDTO serviceBoardDTO = new ServiceBoardDTO(serviceBoardCode, id, serviceBoardTitle, serviceBoardContent, serviceBoardCategory, null, 0);
		serviceBoardService.update(serviceBoardDTO);
		
		serviceBoardDTO = serviceBoardService.selectByServiceBoardCode(serviceBoardCode);
		
		request.setAttribute("serviceBoardDTO", serviceBoardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serRead.jsp");
		return mv;
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int serviceBoardCode = Integer.parseInt(request.getParameter("serviceBoardCode"));
		String id = request.getParameter("id");
		serviceBoardService.delete(serviceBoardCode,id);
		return new ModelAndView("front?key=sb&methodName=selectAll", true);
	}
	
	public ModelAndView insertReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginUser");
		int serviceBoardCode = Integer.parseInt(request.getParameter("serviceBoardCode"));
		String replyContent = request.getParameter("replyContent");
		
		ServiceBoardReplyDTO serviceBoardReplyDTO = new ServiceBoardReplyDTO(0, serviceBoardCode, id, replyContent, null);
		serviceBoardReplyService.insert(serviceBoardReplyDTO);
		ServiceBoardDTO serviceBoardDTO =  serviceBoardService.selectByServiceBoardCode(serviceBoardCode);
		request.setAttribute("serviceBoardDTO", serviceBoardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serRead.jsp");
		
		return mv;
	}

	public ModelAndView updateReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in");
		String updateContent = request.getParameter("updateContent");
		int serviceReplyCode = Integer.parseInt(request.getParameter("updateBoardCode"));
		int serviceBoardCode = Integer.parseInt(request.getParameter("serviceBoardCode"));
		ServiceBoardReplyDTO serviceBoardReplyDTO = new ServiceBoardReplyDTO(serviceReplyCode, 0, null, updateContent, null);
		serviceBoardReplyService.update(serviceBoardReplyDTO);
		
		ServiceBoardDTO serviceBoardDTO =  serviceBoardService.selectByServiceBoardCode(serviceBoardCode);
		request.setAttribute("serviceBoardDTO", serviceBoardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/serRead.jsp");
		
		return mv;
	}
	
	
	

}
