package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.kh.ReviewDAO;
import kosta.mvc.dao.kh.ReviewDAOImpl;
import kosta.mvc.dao.kh.ReviewReplyDAO;
import kosta.mvc.dao.kh.ReviewReplyDAOImpl;
import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ReviewBoardDTO;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	private ReviewReplyDAO replyDAO = new ReviewReplyDAOImpl();
	@Override
	public List<ReviewBoardDTO> selectAll(int pageNo) throws SQLException {
		return reviewDAO.selectAll(pageNo);
	}

	@Override
	public ReviewBoardDTO selectByReviewCode(int reviewCode, boolean flag) throws SQLException {
		if(flag) {
			if(reviewDAO.increamentViews(reviewCode)==0) {
				throw new SQLException("조회수 증가에 오류가 있습니다.");
			}
		}
		ReviewBoardDTO review = reviewDAO.selectByReviewCode(reviewCode);
		if(review==null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		review.setReply(replyDAO.selectByReviewCode(reviewCode));
		return review;
	}

	@Override
	public List<ReviewBoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException {
		List<ReviewBoardDTO> list = reviewDAO.searchBykeyField(keyField, keyWord);
		return list;
	}

	@Override
	public void insert(ReviewBoardDTO review) throws SQLException {
		int result = reviewDAO.insert(review);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void update(ReviewBoardDTO review) throws SQLException {
		int result = reviewDAO.update(review);
		if(result==0) throw new SQLException("수정 실패했습니다.");
	}

	@Override
	public void delete(String id, int reviewCode) throws SQLException {
		replyDAO.deleteAll(reviewCode);
		int result = reviewDAO.delete(id, reviewCode);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
	}

	@Override
	public List<ArtDTO> getArtList(String id) throws SQLException {
		return reviewDAO.getArtList(id);
	}

}
