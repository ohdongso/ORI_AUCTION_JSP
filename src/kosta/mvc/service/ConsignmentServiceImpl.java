package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.kh.ConsignmentDAO;
import kosta.mvc.dao.kh.ConsignmentDAOImpl;
import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ConsignmentDTO;

public class ConsignmentServiceImpl implements ConsignmentService {
	ConsignmentDAO dao = new ConsignmentDAOImpl();
	@Override
	public List<ConsignmentDTO> selectById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public List<ConsignmentDTO> selectAll(int state) throws SQLException {
		if(state!=0) throw new SQLException("관리자 이용 메뉴입니다.");
		return dao.selectAll();
	}

	@Override
	public List<ArtDTO> selectArtById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectArtById(id);
	}

	@Override
	public void insert(ConsignmentDTO consign) throws SQLException {
		int result = dao.insert(consign);
		if(result==0) throw new SQLException("신청에 실패했습니다.");
	}

	@Override
	public ConsignmentDTO selectByCode(int consignCode) throws SQLException {
		ConsignmentDTO con = dao.selectByCode(consignCode);
		if(con==null) throw new SQLException("해당 신청을 찾을 수 없습니다.");
		return con;
	}

	@Override
	public void delete(int consignCode) throws SQLException {
		int result = dao.delete(consignCode);
		if(result==0) throw new SQLException();
	}

	@Override
	public int check(int artCode) throws SQLException {
		if(dao.check(artCode)) {
			return 2;
		}else {
			return 1;
		}
	}

}
