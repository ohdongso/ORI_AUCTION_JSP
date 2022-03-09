package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.dto.ReviewBoardReplyDTO;
import kosta.mvc.service.ReviewReplyService;
import kosta.mvc.service.ReviewReplyServiceImpl;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {
	private ReviewService reviewService = new ReviewServiceImpl();
	private ReviewReplyService replyService = new ReviewReplyServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")) {
			pageNo="1";
		}
		
		List<ReviewBoardDTO> list = reviewService.selectAll(Integer.parseInt(pageNo));
		request.setAttribute("reviewList", list);// ${requestScope.list}사용가능
		request.setAttribute("pageNo", pageNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/list.jsp");
		return mv;
	}

	public ModelAndView selectByReviewCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		ReviewBoardDTO review = reviewService.selectByReviewCode(reviewCode, true);
		request.setAttribute("review", review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/read.jsp");

		return mv;
	}

	
	public ModelAndView insertForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		List<ArtDTO> artList = reviewService.getArtList(id);
		request.setAttribute("artList", artList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/write.jsp");
		return mv;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
		int reviewRate = Integer.parseInt(request.getParameter("reviewRate"));
		String id = request.getParameter("id");
		int artCode = Integer.parseInt(request.getParameter("artCode"));
		ReviewBoardDTO review = new ReviewBoardDTO(0, artCode, id, reviewTitle, reviewContent, null, 0, reviewRate);
		reviewService.insert(review);

		return new ModelAndView("front?key=review&methodName=selectAll", true);
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		int reviewRate = Integer.parseInt(request.getParameter("reviewRate"));
		String id = request.getParameter("id");
		ReviewBoardDTO review = new ReviewBoardDTO(reviewCode, 0, id, reviewTitle, reviewContents, null, 0, reviewRate);
		reviewService.update(review);
		review = reviewService.selectByReviewCode(reviewCode, false);
		System.out.println(review.getReviewTitle());
		request.setAttribute("review", review);
		request.setAttribute("reviewCode", reviewCode);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/read.jsp");
		return mv;
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		String id = request.getParameter("id");
		reviewService.delete(id, reviewCode);
		return new ModelAndView("front?key=review&methodName=selectAll", true);
	}

	public ModelAndView searchByKeyfield(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		List<ReviewBoardDTO> list = reviewService.searchBykeyField(keyField, keyWord);
		request.setAttribute("reviewList", list);// ${requestScope.list}사용가능
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/resultList.jsp");
		return mv;
	}

	public ModelAndView insertReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String replyContent = request.getParameter("replyContent");
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		ReviewBoardReplyDTO reply = new ReviewBoardReplyDTO(0, reviewCode, id, replyContent, null);
		replyService.insert(reply);
		ReviewBoardDTO review = reviewService.selectByReviewCode(reviewCode, false);

		request.setAttribute("review", review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/read.jsp");
		return mv;
	}

	public ModelAndView updateReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewReplyCode = Integer.parseInt(request.getParameter("reviewReplyCode"));
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		String reviewReplyContents = request.getParameter("reviewReplyContents");

		ReviewBoardReplyDTO reply = new ReviewBoardReplyDTO(reviewReplyCode, 0, null, reviewReplyContents, null);
		replyService.update(reply);
		
		ReviewBoardDTO review = reviewService.selectByReviewCode(reviewCode, false);
		request.setAttribute("review", review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/read.jsp");
		return mv;
	}
	
	public ModelAndView deleteReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in");
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		int reviewReplyCode = Integer.parseInt(request.getParameter("reviewReplyCode"));
		String id = request.getParameter("id");
		replyService.delete(id, reviewReplyCode);
		ReviewBoardDTO review = reviewService.selectByReviewCode(reviewCode, false);
		request.setAttribute("review", review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/read.jsp");
		return mv;
	}
	
	

}
