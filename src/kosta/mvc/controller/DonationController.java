package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.DonationDTO;
import kosta.mvc.service.DonationService;
import kosta.mvc.service.DonationServiceImpl;

public class DonationController implements Controller {
	private DonationService donationService = new DonationServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * 전체검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<DonationDTO> list = donationService.selectAll();
		request.setAttribute("donationList", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/donList.jsp");
		
		return mv;
	}
	
	/**
	 * 글 상세보기
	 * */
	public ModelAndView selectByDonCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int donCode = Integer.parseInt(request.getParameter("donCode"));
		
		DonationDTO donationDTO = donationService.selectByDonCode(donCode);
		
		request.setAttribute("donationDTO", donationDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/donRead.jsp");
		return mv;
	
	}
	
	/**
	 * 글 작성
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String donTitle = request.getParameter("donTitle");
		String donContent = request.getParameter("donContent");
		String donDate = request.getParameter("donDate");
		
		DonationDTO donationDTO = new DonationDTO(0, donTitle, donContent, donDate, null);
		donationService.insert(donationDTO);
		
		List<DonationDTO> list = donationService.selectAll();
		request.setAttribute("donationList", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/donList.jsp");
		return mv;
	}
	
	/**
	 * 수정하기 위한 form
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("donCode");
		
		DonationDTO donDTO = donationService.selectByDonCode(Integer.parseInt(code));
		
		request.setAttribute("donDTO", donDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/donUpdate.jsp");
		return mv;
	}
	
	/**
	 * 글 수정
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int donCode = Integer.parseInt(request.getParameter("donCode"));
		String donTitle = request.getParameter("donTitle");
		String donContent = request.getParameter("donContent");
		String donDate = request.getParameter("donDate");
		
		DonationDTO donationDTO = new DonationDTO(donCode, donTitle, donContent, donDate, null);
		
		donationService.update(donationDTO);
		
		donationDTO = donationService.selectByDonCode(donCode);
		request.setAttribute("donationDTO", donationDTO);
		request.setAttribute("donCode", donCode);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("serBoard/donRead.jsp");
		
		return mv;
	}
	
	/**
	 * 글 삭제
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int donCode = Integer.parseInt(request.getParameter("donCode"));
		
		donationService.delete(donCode);
		return new ModelAndView("front?key=donation&methodName=selectAll", true);
	}

}
