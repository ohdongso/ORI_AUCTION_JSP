package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.service.ArtistService;
import kosta.mvc.service.ArtistServiceImpl;
import kosta.mvc.service.MemberService;
import kosta.mvc.service.MemberServiceImpl;

public class ArtistController implements Controller {

	private ArtistService artistService = new ArtistServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 아티스트 등록
	 */
	public ModelAndView registArtist(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding="UTF-8";
		int maxSize=1024*1024*100;
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
		
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		String artistImg = m.getFilesystemName("artistImg");
		String career = m.getParameter("career");
		String artistDetail = m.getParameter("artistDetail");
		String profileLink = m.getParameter("profileLink");
		
		ArtistDTO artistDTO = new ArtistDTO(0, id, artistImg, career, artistDetail, profileLink);
		artistService.registArtist(artistDTO);
		List<ArtistDTO> artistList = artistService.selectAllArtist();
		request.setAttribute("artistList", artistList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("artist/artistList.jsp");
		return mv;
		
	}
	
	/**
	 * 전체 아티스트 조회
	 */
	public ModelAndView selectAllArtist(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<ArtistDTO> artistList = artistService.selectAllArtist();
		request.setAttribute("artistList", artistList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("artist/artistList.jsp");
		return mv;
	}
	
	/**
	 * 키워드로 작가 검색
	 */
	public ModelAndView selectByState(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		List<ArtistDTO> artistList = artistService.selectByState(keyField, keyWord);
		request.setAttribute("artistList", artistList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("artist/artistList.jsp");
		return mv;
	}
	
	/**
	 * 아티스트 정보 수정( 커리어, 디테일)
	 */
	public ModelAndView updateArtist(HttpServletRequest request, HttpServletResponse response)throws Exception { 
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding="UTF-8";
		int maxSize=1024*1024*100;
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
		
		String career = m.getParameter("career");
		String artistDetail = m.getParameter("artistDetail");
		String profileLink = m.getParameter("profileLink");
		
		ArtistDTO artistDTO = new ArtistDTO(0, id, null, career, artistDetail, profileLink);
		
		//파일 첨부가 되었다면
				if(m.getFilesystemName("file") !=null) {//수정하려민 파일이 있다면....
					//첨부된파일이름과 사이즈를 저장
					artistDTO.setArtistImg(m.getFilesystemName("file"));
				}else {
					artistDTO.setArtistImg(m.getParameter("beforFileName"));
				}
		artistService.updateArtist(artistDTO);
		
		List<ArtistDTO> artistList = artistService.selectAllArtist();
		request.setAttribute("artistList", artistList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("artist/artistList.jsp");
		return mv;
	}
	
	/**
	 * 아티스트 삭제
	 */
	public ModelAndView deleteArtist(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		artistService.deleteArtist(id);
		List<ArtistDTO> artistList = artistService.selectAllArtist();
		request.setAttribute("artistList", artistList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("artist/artistList.jsp");
		return mv;
	}
}
