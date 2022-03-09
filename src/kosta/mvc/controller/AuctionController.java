package kosta.mvc.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dao.ds.AuctionDAO;
import kosta.mvc.dao.ds.AuctionDAOImpl;
import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.AuctionDTO;
import kosta.mvc.dto.ConsignmentDTO;
import kosta.mvc.service.AuctionService;
import kosta.mvc.service.AuctionServiceImpl;
import kosta.mvc.service.ConsignmentService;
import kosta.mvc.service.ConsignmentServiceImpl;
import kosta.mvc.service.LikedArtService;
import kosta.mvc.service.LikedArtServiceImpl;

public class AuctionController implements Controller {
	private AuctionService auctionService = new AuctionServiceImpl();
	private AuctionDAO auctionDAO = new AuctionDAOImpl();
	private ConsignmentService consignmentService = new ConsignmentServiceImpl();
	private LikedArtService likedArtService = new LikedArtServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 전체검색
	 */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<AuctionDTO> AuctionDtoList = auctionService.selectAll();
		request.setAttribute("AuctionDtoList", AuctionDtoList);

		List<ArtDTO> ArtDtoList = new ArrayList<ArtDTO>();
		for (AuctionDTO auctionDTO : AuctionDtoList) {
			ArtDtoList.add(auctionService.auctionArtSearch(auctionDTO));
		}

		request.setAttribute("ArtDtoList", ArtDtoList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/totalAuction.jsp");

		return mv;
	}
	
	/**
	 * (일반, 제로베이스, 자선)경매 검색
	 */
	public ModelAndView selectAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCategory = Integer.parseInt(request.getParameter("aucCategory"));
		List<AuctionDTO> AuctionDtoList = auctionService.selectAuction(aucCategory);
		request.setAttribute("AuctionDtoList", AuctionDtoList);
		
		List<ArtDTO> ArtDtoList = new ArrayList<ArtDTO>();
		for (AuctionDTO auctionDTO : AuctionDtoList) {
			ArtDtoList.add(auctionService.auctionArtSearch(auctionDTO));
		}

		request.setAttribute("ArtDtoList", ArtDtoList);
		ModelAndView mv = new ModelAndView();

		switch (aucCategory) {
		case 1:
			mv.setViewName("auction/generalAuction.jsp");
			break;
		case 2:
			mv.setViewName("auction/charityAuction.jsp");
			break;
		case 3:
			mv.setViewName("auction/zerobaseAuction.jsp");
			break;
		}
		return mv;
	}
	
	/**
	 * 조건 경매검색
	 * */
	public ModelAndView searchByAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCategory = Integer.parseInt(request.getParameter("aucCategory"));
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		List<ArtDTO> ArtDtoList = auctionService.searchByAuction(keyField, keyWord);
		request.setAttribute("ArtDtoList", ArtDtoList);
		
		ModelAndView mv = new ModelAndView();
		
		switch (aucCategory) {
		case 0:
			mv.setViewName("auction/totalAuction.jsp");
			break;
		case 1:
			mv.setViewName("auction/generalAuction.jsp");
			break;
		case 2:
			mv.setViewName("auction/charityAuction.jsp");
			break;
		case 3:
			mv.setViewName("auction/zerobaseAuction.jsp");
			break;
		}
		return mv;
	}
	
	/**
	 * 조건 경매검색 min, max
	 * */
	public ModelAndView searchMinMax(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int aucCategory = Integer.parseInt(request.getParameter("aucCategory"));
			int min = Integer.parseInt(request.getParameter("min"));
			int max = Integer.parseInt(request.getParameter("max"));
			List<ArtDTO> ArtDtoList = auctionService.searchMinMax(min, max);
			
			request.setAttribute("ArtDtoList", ArtDtoList);
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("auction/totalAuction.jsp");
			
			switch (aucCategory) {
			case 0:
				mv.setViewName("auction/totalAuction.jsp");
				break;
			case 1:
				mv.setViewName("auction/generalAuction.jsp");
				break;
			case 2:
				mv.setViewName("auction/charityAuction.jsp");
				break;
			case 3:
				mv.setViewName("auction/zerobaseAuction.jsp");
				break;
			}
			
			return mv;
	}
	
	/**
	 * 작품 상세보기
	 * */
	public ModelAndView selectDetailArt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int artCode = Integer.parseInt(request.getParameter("artCode"));
		ArtDTO artDTO = auctionService.selectDetailArt(artCode);
		// System.out.println(artDTO.getArtImg());
		
		// artCode로 경매코드 가져오기
		int aucCode = auctionService.selectDetailAucCode(artCode);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		int flag = likedArtService.check(id,aucCode);
		
		request.setAttribute("flag", flag);		
		request.setAttribute("artDTO", artDTO);
		request.setAttribute("aucCode", aucCode);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/detailArt.jsp");
		
		return mv;
	}
	
	/**
	 * 경매관리 페이지를 클릭했을 때, 경매에 대한 정보를 보여주는 메소드
	 * */
	public ModelAndView adminSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<AuctionDTO> auctionDtoList = auctionService.adminSelectAll();
		request.setAttribute("auctionDtoList", auctionDtoList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/manageAuction.jsp");

		return mv;
	}
	
	/**
	 * 경매 상태에 대해서 검색
	 * */
	public ModelAndView searchByState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int state = Integer.parseInt(request.getParameter("state"));
		
		List<AuctionDTO> auctionDtoList = auctionService.searchByState(state);
		
		request.setAttribute("auctionDtoList", auctionDtoList);
		ModelAndView mv = new ModelAndView();
		
		switch (state) {
		case 1:
			mv.setViewName("auction/ingAuction.jsp");
			break;
		case 2:
			mv.setViewName("auction/scheduleAuction.jsp");
			break;
		case 3:
			mv.setViewName("auction/endAuction.jsp");
			break;
		}
		return mv;
	}
	
	/**
	 * 진행경매 경매종료
	 * */
	public ModelAndView endAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int state = Integer.parseInt(request.getParameter("state"));
		
		List<AuctionDTO> auctionDtoList = auctionService.endAuction(aucCode ,state);
		
		request.setAttribute("auctionDtoList", auctionDtoList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/ingAuction.jsp");
		
		return mv;
	}
	
	/**
	 * 예정경매 개시하는 기능
	 * */
	public ModelAndView startAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int state = Integer.parseInt(request.getParameter("state"));
		
		List<AuctionDTO> auctionDtoList = auctionService.startAuction(aucCode, state);
		
		request.setAttribute("auctionDtoList", auctionDtoList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/scheduleAuction.jsp");
		
		return mv;
	}
	
	/**
	 * 경매 수정시, updateAuction.jsp까지 정보를 전달 하는 기능
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int aucState = Integer.parseInt(request.getParameter("aucState"));
		int artCode = Integer.parseInt(request.getParameter("artCode"));
		
		AuctionDTO auctionDto = auctionService.updateForm(aucCode, aucState, artCode);

		request.setAttribute("auctionDto", auctionDto);
		request.setAttribute("aucCode", aucCode);
		request.setAttribute("aucState", aucState);
		request.setAttribute("artCode", artCode);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/updateAuction.jsp");
		
		return mv;
	}
	
	/**
	 * 경매 수정
	 * */
	public ModelAndView updateAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int aucState = Integer.parseInt(request.getParameter("aucState"));
		int artCode = Integer.parseInt(request.getParameter("artCode")) ;
		int updateStartCost = Integer.parseInt(request.getParameter("updateStartCost"));
		
		List<AuctionDTO> auctionDtoList = auctionService.updateAuction(aucCode, aucState, artCode, updateStartCost);
		request.setAttribute("auctionDtoList", auctionDtoList);
		
		ModelAndView mv = new ModelAndView();
		
		switch (aucState) {
		case 1:
			mv.setViewName("auction/ingAuction.jsp");
			break;
		case 2:
			mv.setViewName("auction/scheduleAuction.jsp");
			break;
		}
		return mv;
	}
	
	/**
	 * 경매삭제
	 * */
	public ModelAndView deleteAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int aucState = Integer.parseInt(request.getParameter("aucState"));
		int artCode = Integer.parseInt(request.getParameter("artCode")) ;
		
		List<AuctionDTO> auctionDtoList = auctionService.deleteAuction(aucCode, aucState, artCode);
		request.setAttribute("auctionDtoList", auctionDtoList);
		
		ModelAndView mv = new ModelAndView();
		
		switch (aucState) {
		case 1:
			mv.setViewName("auction/ingAuction.jsp");
			break;
		case 2:
			mv.setViewName("auction/scheduleAuction.jsp");
			break;
		case 3:
			mv.setViewName("auction/endAuction.jsp");
			break;
		}
		return mv;
	}
	
	/**
	 * 유찰이 아닌 최종경매가 종료된 사람을 낙찰테이블로 등록
	 * */
	public ModelAndView insertSuccedBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aucCode = Integer.parseInt(request.getParameter("aucCode"));
		int artCode = Integer.parseInt(request.getParameter("artCode"));
		int aucState = Integer.parseInt(request.getParameter("state"));
		int result = 0;
		
		// 최종응찰된 사람의 ID
		String id = auctionService.getMaxCostId(aucCode);
	
		// 응찰된 가격중 최고가
		int maxCost = auctionDAO.getMaxCost(aucCode);
		
		result = auctionService.insertSuccedBid(aucCode, aucState, artCode, id, maxCost);
		
		// 경매상태 5번으로 변경.
		List<AuctionDTO> auctionDtoList = auctionDAO.updateAuctionState(aucCode, artCode, aucState);
		
		request.setAttribute("auctionDtoList", auctionDtoList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auction/endAuction.jsp");
		return mv;
	}
	
	/**
	 * 관리자가 최종 승인한, 위탁신청을 예정경매에 등록하는 기능
	 * */
	public ModelAndView insertScheduledAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// insert into auction values(옥션코드(AUCTION_SEQ.NEXTVAL), 작품코드, 경매시작가, 경매카테고리(), 경매상태(2), 경매시작일);
		int artCode = Integer.parseInt(request.getParameter("artCode"));	
		int estimateCost = Integer.parseInt(request.getParameter("estimateCost"));
		double startCost = (double)(estimateCost * 0.6);
		int aucCategory = Integer.parseInt(request.getParameter("auctionCategory"));
		int result = 0;
		
		result = auctionService.insertScheduledAuction(artCode, (int)startCost, aucCategory);
			
		HttpSession session = request.getSession();
		int state = (Integer)session.getAttribute("loginState");
		List<ConsignmentDTO> conList = consignmentService.selectAll(state);
		
		request.setAttribute("conList", conList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consignment/list.jsp");
		return mv;
	}
}