package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.LikedArtDTO;

public interface LikedArtService {

	public void registInterest(LikedArtDTO likedArtDTO)throws SQLException;

	public List<LikedArtDTO> selectAll(String id, boolean flag)throws SQLException;

	public void deleteInterest(int aucCode, String id)throws SQLException;

	public int check(String id,int aucCode)throws SQLException;
	

}
