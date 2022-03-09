package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.dto.LikedArtDTO;
import kosta.mvc.service.LikedArtService;
import kosta.mvc.service.LikedArtServiceImpl;

public class LikedArtController implements Controller {

	private LikedArtService likedArtService = new LikedArtServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 관심 경매 등록
	 */
	public ModelAndView registInterest(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		LikedArtDTO likedArtDTO = new LikedArtDTO(0, id, aucCode);
		likedArtService.registInterest(likedArtDTO);
		List<LikedArtDTO> likeList = likedArtService.selectAll(id, false);
		request.setAttribute("likedArtDTO", likeList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("like/likeList.jsp");
		return mv;
	}
	
	/**
	 * id에 해당하는 관심 경매 목록 조회
	 */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		List<LikedArtDTO> likedArtDTO = likedArtService.selectAll(id, false);
		request.setAttribute("likedArtDTO", likedArtDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("like/likeList.jsp");
		return mv;
	}
	
	/**
	 * 관심 경매 삭제
	 */
	public ModelAndView deleteInterest(HttpServletRequest request, HttpServletResponse response)throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		likedArtService.deleteInterest(aucCode, id);
		List<LikedArtDTO> likeList = likedArtService.selectAll(id, false);
		request.setAttribute("likedArtDTO", likeList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("like/likeList.jsp");
		return mv;
	}
}
