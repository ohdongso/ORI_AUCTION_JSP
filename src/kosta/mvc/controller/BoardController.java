package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.BoardDTO;
import kosta.mvc.dto.BoardReplyDTO;
import kosta.mvc.service.BoardReplyService;
import kosta.mvc.service.BoardReplyServiceImpl;
import kosta.mvc.service.BoardService;
import kosta.mvc.service.BoardServiceImpl;

public class BoardController implements Controller {
	private BoardService boardService = new BoardServiceImpl();
	private BoardReplyService replyService = new BoardReplyServiceImpl();
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
		List<BoardDTO> list = boardService.selectAll(Integer.parseInt(pageNo));
		request.setAttribute("boardList", list);//${requestScope.boardlist}사용가능
		request.setAttribute("pageNo", pageNo);//${requestScope.list} 사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msBoard/list.jsp");
		
		return mv;
	}
	/**
	 * 
	 * 코드번호에 해당하는 정보 검색하기(상세보기)
	 * */
	public ModelAndView selectByBoardcode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int boardCode = Integer.parseInt(request.getParameter("boardCode"));
	
		BoardDTO board =  boardService.selectByBoardCode(boardCode, true);//true는 조회수 증가!!
		
	
		request.setAttribute("board", board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msBoard/read.jsp");
		return mv;
	
	}
	
	/**
	 * 키에 해당하는 정보 검색하기
	 * */
	public ModelAndView searchByKeyfield(HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		List<BoardDTO> list =  boardService.searchBykeyField(keyField, keyWord);
		request.setAttribute("boardList", list);//${requestScope.list}사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msBoard/resultList.jsp");
		return mv;
	}
	
	
	/**
	 * 카테고리에 해당하는 정보 검색(공지사항을 함께 가져온다) 
	 * */
	public ModelAndView searchByCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int boardCategory = Integer.parseInt(request.getParameter("boardCategory"));	
		List<BoardDTO> category =  boardService.searchByCategory(boardCategory);//true는 조회수 증가!!
		
		request.setAttribute("boardList", category);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msBoard/resultList.jsp");
		return mv;
	}
	
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//전송된 데이터 받기 ->dto만든다.
		String saveDir = request.getServletContext().getRealPath("save");
		String encoding = "UTF-8";
		int maxSize= 1024*1024*100;//100M
		
		HttpSession session =	request.getSession();		
		String id = (String)session.getAttribute("loginUser");
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize,encoding,new DefaultFileRenamePolicy());
		
		int boardCategory = Integer.parseInt(m.getParameter("boardCategory"));
		String boardTitle = m.getParameter("boardTitle");
		String boardContent = m.getParameter("boardContent");
		
		
		BoardDTO board = new BoardDTO(id,0,boardCategory,boardTitle,boardContent,null,0,null);
		
		
		
		
		
		//파일 첨부가 되었다면
		if(m.getFilesystemName("file") !=null) {
			//첨부된파일이름과 사이즈를 저장
			board.setFile(m.getFilesystemName("file"));
			
			
		}
		boardService.insert(board);

		
		
		
		
		return new ModelAndView("front?key=board&methodName=selectAll", true);
	}
	
	
	/**
	 * 수정완료하기
	 **/ 
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String saveDir = request.getServletContext().getRealPath("save");
		String encoding = "UTF-8";
		int maxSize= 1024*1024*100;//100M
		
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize,encoding,new DefaultFileRenamePolicy());
		
		int boardCategory = Integer.parseInt(m.getParameter("boardCategory"));
		int boardCode = Integer.parseInt(m.getParameter("boardCode"));		
		String boardTitle = m.getParameter("boardTitle");
	
		String boardContent = m.getParameter("boardContent");
		
		HttpSession session =	request.getSession();
		
		String id = (String)session.getAttribute("loginUser");
		
		BoardDTO board = new BoardDTO(id,boardCode, boardCategory, boardTitle, boardContent, null, 0, null);
		
		
		//파일 첨부가 되었다면
		if(m.getFilesystemName("file") !=null) {
			//첨부된파일이름과 사이즈를 저장
			board.setFile(m.getFilesystemName("file"));
		}else {
			board.setFile(m.getParameter("beforeFile"));
		}
		
	
		boardService.update(board);
		board= boardService.selectByBoardCode(boardCode,false);
		
		
		request.setAttribute("board", board);
		request.setAttribute("boardCode", boardCode);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("msBoard/read.jsp");
		return mv;
	}
	
	
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int boardCode = Integer.parseInt(request.getParameter("boardCode")) ;
		
		String id = request.getParameter("id");
		
		boardService.delete(boardCode,id);
		return new ModelAndView("front?key=board&methodName=selectAll", true);

	}
	/*
	 * 댓글 등록
	 * */
	public ModelAndView insertReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	HttpSession session =	request.getSession();
		
		String id = (String)session.getAttribute("loginUser");
		
		String replyContent = request.getParameter("replyContent");
		int boardCode = Integer.parseInt(request.getParameter("boardCode"));
		
		
		
		BoardReplyDTO reply = new BoardReplyDTO(0, id, boardCode, replyContent, null);
		replyService.insert(reply);
		
		BoardDTO board = boardService.selectByBoardCode(boardCode, false);	
		request.setAttribute("board", board);
		
		
		return new ModelAndView("msBoard/read.jsp",false);
	}
	/**
	 * 댓글수정
	 **/ 
	public ModelAndView updateReply(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		HttpSession session =	request.getSession();		
		String userid = (String)session.getAttribute("loginUser");//로그인사용자 아이디
		
	    int boardReplyCode = Integer.parseInt(request.getParameter("boardReplyCode"));//현재 댓글번호
		int boardCode = Integer.parseInt(request.getParameter("boardCode"));//부모글번호
		String boardReplyContent = request.getParameter("boardReplyContent");	
		
	
		BoardReplyDTO reply = new BoardReplyDTO(boardReplyCode, userid, boardCode, boardReplyContent, null);
		replyService.update(reply);
		
		
		return new ModelAndView("front?key=board&methodName=selectByBoardcode&boardCode="+boardCode, true);
	}
	

	public ModelAndView deleteReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardCode = Integer.parseInt(request.getParameter("boardCode"));
		int boardReplyCode = Integer.parseInt(request.getParameter("boardReplyCode"));
		
		String id = request.getParameter("id");
		
		
		
		replyService.delete(id, boardReplyCode);		
		BoardDTO board = boardService.selectByBoardCode(boardCode, false);
		
		request.setAttribute("board", board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msBoard/read.jsp");
		return mv;
	}
	

	/**
	 * 삭제하기(관리자)
	 * */
	public ModelAndView deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int boardCode = Integer.parseInt(request.getParameter("boardCode")) ;
		
		
		
		boardService.deleteAdmin(boardCode, null);
		return new ModelAndView("front?key=board&methodName=selectAll", true);

	}
	
}
