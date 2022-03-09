package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ms.BoardDAO;
import kosta.mvc.dao.ms.BoardDAOImpl;
import kosta.mvc.dao.ms.BoardReplyDAO;
import kosta.mvc.dao.ms.BoardReplyDAOImpl;
import kosta.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAOImpl();
	private BoardReplyDAO replyDAO = new BoardReplyDAOImpl();
	@Override
	public List<BoardDTO> selectAll(int pageNo) throws SQLException {
		return boardDAO.selectAll(pageNo);
	}
	
	
	@Override
	public BoardDTO selectByBoardCode(int boardCode, boolean flag) throws SQLException {
		//조회수 증가
				if(flag) {
					if( boardDAO.increamentByViews(boardCode)==0) {
						throw new SQLException("조회수 증가에 오류가 있습니다..");
					}
				}
				
				
				BoardDTO board= boardDAO.selectByBoardCode(boardCode);
				if(board==null) {
					throw new SQLException("정보를 검색하지 못했습니다..");
				}
				board.setReply(replyDAO.selectByBoardCode(boardCode));
				
				return board;
			}
	
	
	
	
	@Override
	public List<BoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException {
		List<BoardDTO> list = boardDAO.searchByKeyField(keyField, keyWord);
		if(list.size()==0) {
			throw new SQLException("검색결과가 없습니다.");
		}
		return list;
	}

	@Override
	public List<BoardDTO> searchByCategory(int boardCategory) throws SQLException {
		
		return boardDAO.searchByCategory(boardCategory);
	}

	@Override
	public void insert(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.insert(boardDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다");

	}

	@Override
	public void update(BoardDTO boardDTO) throws SQLException {
		
		int result = boardDAO.update(boardDTO);
		if(result==0) {
			throw new SQLException("수정되지 않았습니다.");
		}

	

	}

	@Override
	public void delete(int boardCode,String id) throws SQLException {
		replyDAO.deleteAll(boardCode);
		int result = boardDAO.delete(boardCode,id);
	     if(result == 0)throw new SQLException("삭제되지않았습니다.");

	}

	@Override
	public void deleteAdmin(int boardCode, String id) throws SQLException {
			replyDAO.deleteAll(boardCode);
		int result = boardDAO.deleteAdmin(boardCode,id);
	     if(result == 0)throw new SQLException("삭제되지않았습니다.");

	}

	
	
}
