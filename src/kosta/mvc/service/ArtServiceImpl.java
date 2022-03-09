package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.dh.ArtDAO;
import kosta.mvc.dao.dh.ArtDAOImpl;
import kosta.mvc.dto.ArtDTO;

public class ArtServiceImpl implements ArtService {

	private ArtDAO artDAO = new ArtDAOImpl();
	
	// 작품 전체 검색
	@Override
	public List<ArtDTO> selectAll() throws SQLException {
		return artDAO.selectAll();
	}

	// 작품 코드로 검색
	@Override
	public ArtDTO searchByArtCode(int code) throws SQLException {
		ArtDTO art = artDAO.searchByArtCode(code);
		if(art==null) throw new SQLException("해당하는 작품이 존재하지 않습니다.");
		return art;
	}
	
	// keyField와 keyWord로 검색
	@Override
	public List<ArtDTO> searchByKeyWord(String keyField, String keyWord) throws SQLException {
		List<ArtDTO> list = artDAO.searchByKeyField(keyField, keyWord);
		if(list==null) throw new SQLException("해당하는 작품이 존재하지 않습니다.");
		return list;
	}
	
	@Override
	public List<ArtDTO> searchByKeyWordUser(String keyField, String keyWord, String id) throws SQLException {
		List<ArtDTO> list = artDAO.searchByKeyWordUser(keyField, keyWord, id);
		if(list==null) throw new SQLException("해당하는 작품이 존재하지 않습니다.");
		return list;
	}

	// 회화, 사진 작품 검색
	@Override
	public List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth) throws SQLException {
		
		return null;
	}

	// 공예, 조각 작품 검색
	@Override
	public List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth, int minVol, int maxVol)
			throws SQLException {
		
		return null;
	}

	// 작품 등록(일반)
	@Override
	public void insertArt(ArtDTO artDTO) throws SQLException {
		int result = artDAO.insertArt(artDTO);
		if(result==0) throw new SQLException("작품이 등록되지 않았습니다.");
	}
	
	// 작품 등록(제로베이스)
	@Override
	public void insertArtZB(ArtDTO artDTO) throws SQLException {
		int result = artDAO.insertArtZB(artDTO);
		if(result==0) throw new SQLException("작품이 등록되지 않았습니다.");
	}

	// 작품 수정
	@Override
	public void updateArt(ArtDTO artDTO) throws SQLException {
		int result = artDAO.updateArt(artDTO);
		if(result==0) throw new SQLException("작품 정보 수정에 실패했습니다.");
	}

	// 작품 삭제
	@Override
	public void deleteArt(int artCode) throws SQLException {
		int result = artDAO.deleteArt(artCode);
		if(result==0) throw new SQLException("작품 정보 삭제에 실패했습니다.");
	}


}
