package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.sy.LikedArtDAO;
import kosta.mvc.dao.sy.LikedArtDAOImpl;
import kosta.mvc.dto.LikedArtDTO;

public class LikedArtServiceImpl implements LikedArtService {
	
	private LikedArtDAO likedArtDAO = new LikedArtDAOImpl();
	
	/**
	 * 관심 경매 등록
	 */
	@Override
	public void registInterest(LikedArtDTO likedArtDTO)throws SQLException {
		int result = likedArtDAO.registInterest(likedArtDTO);
		if(result==0)throw new SQLException("관심경매 등록 실패. 다시 시도해주세요");
	}
	/**
	 * id에 해당하는 관심 경매 목록 조회
	 */
	@Override
	public List<LikedArtDTO> selectAll(String id, boolean flag) throws SQLException{
		return likedArtDAO.selectAll(id);
	}
	/**
	 * 관심 경매 삭제
	 */
	@Override
	public void deleteInterest(int aucCode, String id)throws SQLException {
		int result = likedArtDAO.deleteInterest(aucCode, id);
		if(result==0)throw new SQLException("관심경매 등록 실패. 다시 시도해주세요");
	}
	
	@Override
	public int check(String id, int aucCode) throws SQLException {
		if(likedArtDAO.check(id,aucCode))return 1; //이미 등록.
		else return 2;//등록가능
	}

}
