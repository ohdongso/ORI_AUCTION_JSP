package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.sy.ArtistDAO;
import kosta.mvc.dao.sy.ArtistDAOImpl;
import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.dto.MemberDTO;

public class ArtistServiceImpl implements ArtistService {

	private ArtistDAO artistDAO = new ArtistDAOImpl();
	
	/**
	 * 작가 등록
	 */
	@Override
	public void registArtist(ArtistDTO artistDTO) throws SQLException {
		int result = artistDAO.registArtist(artistDTO);
		if(result==0)throw new SQLException("작가 등록 실패. 다시 시도해주세요");
	}
	/**
	 * 전체 작가 목록 조회 -- 회원
	 */
	@Override
	public List<ArtistDTO> selectAllArtist() throws SQLException {
		return artistDAO.selectAllArtist();
	}
	/**
	 * 키워드로 작가 검색
	 */
	@Override
	public List<ArtistDTO> selectByState(String keyField, String keyWord) throws SQLException  {
		List<ArtistDTO> list = artistDAO.selectByState(keyField, keyWord);
		if(list==null)throw new SQLException("검색 키워드에 해당하는 회원이 존재하지 않습니다.");
		return list;
	}
	/**
	 * 아티스트 정보 수정
	 */
	@Override
	public void updateArtist(ArtistDTO aritstDTO) throws SQLException {
		int result = artistDAO.updateArtist(aritstDTO);
		if(result==0)throw new SQLException("정보 수정 오류. 다시 시도해주세요");
		}
	/**
	 * 아티스트 삭제 
	 */
	@Override
	public void deleteArtist(String id) throws SQLException {
		int result = artistDAO.deleteArtist(id);
		if(result==0)throw new SQLException("아티스트 삭제 실패. 다시 시도해주세요");
	}

}
