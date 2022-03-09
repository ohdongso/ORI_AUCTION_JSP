package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ConsignmentDTO;
import kosta.mvc.dto.ConsignmentReplyDTO;
import kosta.mvc.service.ConsignmentReplyService;
import kosta.mvc.service.ConsignmentReplyServiceImpl;
import kosta.mvc.service.ConsignmentService;
import kosta.mvc.service.ConsignmentServiceImpl;

public class ConsignmentController implements Controller {
	private ConsignmentService consService = new ConsignmentServiceImpl();
	private ConsignmentReplyService consReplyService = new ConsignmentReplyServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView selectById(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		List<ConsignmentDTO> conList = consService.selectById(id);
		request.setAttribute("conList", conList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/list.jsp");
		return mv;
	}
	
	public ModelAndView insertForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		List<ArtDTO> artList = consService.selectArtById(id);
		request.setAttribute("artList", artList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/write.jsp");
		return mv;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		int artCode = Integer.parseInt(request.getParameter("artCode"));
		int consignCategory = Integer.parseInt(request.getParameter("consCategory"));
		ConsignmentDTO consign = new ConsignmentDTO(0, id, artCode, null, 0, consignCategory);
		
		consService.insert(consign);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=cons&methodName=selectById");
		return mv;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		int state = (Integer)session.getAttribute("loginState");
		List<ConsignmentDTO> conList = consService.selectAll(state);
		
		request.setAttribute("conList", conList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/list.jsp");
		return mv;
	}
	
	public ModelAndView selectByCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int consignCode = Integer.parseInt(request.getParameter("consignCode"));
		ConsignmentDTO cons = consService.selectByCode(consignCode);
		int flag = consService.check(cons.getArtCode());
		request.setAttribute("cons", cons);
		request.setAttribute("flag", flag);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/read.jsp");
		return mv;
	}
	
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int consignCode = Integer.parseInt(request.getParameter("consignCode"));
		consService.delete(consignCode);

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		List<ConsignmentDTO> conList = consService.selectById(id);
		request.setAttribute("conList", conList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/list.jsp");
		return mv;
	}
	
	public ModelAndView insertReply(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		int consignCode = Integer.parseInt(request.getParameter("consignCode"));
		String replyContent = request.getParameter("replyContent");
		String id = (String)session.getAttribute("loginUser");
		ConsignmentReplyDTO reply = new ConsignmentReplyDTO(0, consignCode, id, replyContent, null);
		consReplyService.insertReply(reply);
		
		
		ConsignmentDTO cons = consService.selectByCode(consignCode);
		request.setAttribute("cons", cons);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/read.jsp");
		return mv;
	}
	
}
