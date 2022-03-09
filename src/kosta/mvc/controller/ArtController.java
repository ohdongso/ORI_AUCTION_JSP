package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.DonationDTO;
import kosta.mvc.service.ArtService;
import kosta.mvc.service.ArtServiceImpl;

public class ArtController implements Controller {
	
	private ArtService artService = new ArtServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * 작품 등록
	 * */
	public ModelAndView insertArt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding="UTF-8";
		int maxSize=1024*1024*100;
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
		
		String id = m.getParameter("id");
		String artistCode = m.getParameter("artistCode");
		String artName = m.getParameter("artName");
		String artistName = m.getParameter("artistName");
		String artCategory = m.getParameter("artCategory");
		String artState = m.getParameter("artState");
		String artSizeHeight = m.getParameter("artSizeHeight");
		String artSizeWidth = m.getParameter("artSizeWidth");
		String artSizeVol = m.getParameter("artSizeVol");
		String estimateCost = m.getParameter("estimateCost");
		String prdYear = m.getParameter("prdYear")+"/01/01";
		String artDetail = m.getParameter("artDetail");
		String artImg = m.getFilesystemName("artImg");
		
		ArtDTO art = new ArtDTO(0,id,artName,artistName,Integer.parseInt(artCategory),
				Integer.parseInt(artState),Integer.parseInt(artSizeHeight),Integer.parseInt(artSizeWidth),
				Integer.parseInt(artSizeVol),Integer.parseInt(estimateCost),prdYear,artDetail,artImg);
		
		// artistCode가 없는 경매인 경우
		if(artistCode==null || artistCode=="0") {
			artService.insertArt(art);
		
		// artistCode가 있는 경매인 경우
		}else{
			art.setArtistCode(Integer.parseInt(artistCode));
			artService.insertArtZB(art);
		}

		//return new ModelAndView("art/artmain.jsp", true);
		request.setAttribute("art", art);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/front?key=art&methodName=searchByKeyWord&keyField=id&keyWord="+id);
		
		return mv;
	}

	/**
	 * 전체 작품 검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ArtDTO> artList = artService.selectAll();
		request.setAttribute("artList", artList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("art/artlist.jsp");
		
		return mv;
	}
	
	/**
	 * 작품 코드로 작품 검색
	 * */
	public ModelAndView searchByArtCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String artCode = request.getParameter("artCode");
		
		ArtDTO art = artService.searchByArtCode(Integer.parseInt(artCode));
		
		request.setAttribute("art", art);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("art/artRead.jsp");
		return mv;
	}
	
	/**
	 * 작품 코드로 낙찰된 작품 결제 표시할 때
	 * */
	public ModelAndView selectSucBidArt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sucBidCode = request.getParameter("sucBidCode");
		String artCode = request.getParameter("artCode");
		String sucBidCost = request.getParameter("sucBidCost");
		String sucBidId = request.getParameter("sucBidId");
		
		ArtDTO art = artService.searchByArtCode(Integer.parseInt(artCode));
		
		request.setAttribute("art", art);
		request.setAttribute("sucBidCode", sucBidCode);
		request.setAttribute("sucBidCost", sucBidCost);
		request.setAttribute("sucBidId", sucBidId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("payment/itemDetail.jsp");
		return mv;
	}
	
	
	/**
	 * keyField와 keyWord로 검색
	 * */
	public ModelAndView searchByKeyWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		List<ArtDTO> artList = null;
		
		artList = artService.searchByKeyWord(keyField, keyWord);
		
		request.setAttribute("artList", artList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("art/artlist.jsp");
		
		return mv;
	}
	
	/**
	 * keyField와 keyWord로 검색(회원)
	 * */
	public ModelAndView searchByKeyWordUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		String id = request.getParameter("userId");
		
		List<ArtDTO> artList = null;
		
		artList = artService.searchByKeyWordUser(keyField, keyWord, id);
		
		request.setAttribute("artList", artList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("art/artlist.jsp");
		
		return mv;
	}
	
	/**
	 * 수정하기 위한 form
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String artCode = request.getParameter("artCode");
		
		ArtDTO artDTO = artService.searchByArtCode(Integer.parseInt(artCode));
		
		request.setAttribute("artDTO", artDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("art/artUpdate.jsp");
		return mv;
	}
	
	/**
	 * 작품 정보 수정  -- 관리자 메뉴
	 * */
	public ModelAndView updateArt(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding="UTF-8";
		int maxSize=1024*1024*100;
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
		
		String artCode = m.getParameter("artCode");
		String id = m.getParameter("id");
		//String artistCode = m.getParameter("artistCode");
		String artName = m.getParameter("artName");
		String artistName = m.getParameter("artistName");
		String artCategory = m.getParameter("artCategory");
		String artState = m.getParameter("artState");
		String artSizeHeight = m.getParameter("artSizeHeight");
		String artSizeWidth = m.getParameter("artSizeWidth");
		String artSizeVol = m.getParameter("artSizeVol");
		String estimateCost = m.getParameter("artEstimateCost");
		String prdYear = m.getParameter("artPrdYear")+"/01/01";
		String artDetail = m.getParameter("artDetail");
		//String artImg = m.getFilesystemName("artImg");
		
		ArtDTO art = new ArtDTO(Integer.parseInt(artCode),id,artName,artistName,Integer.parseInt(artCategory),
				Integer.parseInt(artState),Integer.parseInt(artSizeHeight),Integer.parseInt(artSizeWidth),
				Integer.parseInt(artSizeVol),Integer.parseInt(estimateCost),prdYear,artDetail,null);
		//art.setArtistCode(Integer.parseInt(artistCode));
		
		if(m.getFilesystemName("artImg")!=null) {
			art.setArtImg(m.getFilesystemName("artImg"));
		}else {
			art.setArtImg(m.getParameter("beforeImg"));
		}
		
		artService.updateArt(art);
		
		art = artService.searchByArtCode(Integer.parseInt(artCode));
		request.setAttribute("art", art);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=art&methodName=selectAll");
		return mv;
	}
	
	/**
	 * 작품 정보 삭제 -- 관리자 메뉴
	 * */
	public ModelAndView deleteArt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String artCode = request.getParameter("artCode");
		
		artService.deleteArt(Integer.parseInt(artCode));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=art&methodName=selectAll");
		return mv;
	}
}
