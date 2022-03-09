package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.sh.DonationDAO;
import kosta.mvc.dao.sh.DonationDAOImpl;
import kosta.mvc.dto.DonationDTO;

public class DonationServiceImpl implements DonationService {
	private DonationDAO donationDAO = new DonationDAOImpl();

	@Override
	public List<DonationDTO> selectAll() throws SQLException {
		return donationDAO.selectAll();
	}

	@Override
	public DonationDTO selectByDonCode(int donCode) throws SQLException {
		return donationDAO.selectByDonCode(donCode);
	}

	@Override
	public void insert(DonationDTO donationDTO) throws SQLException {
		int result = donationDAO.insert(donationDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void update(DonationDTO donationDTO) throws SQLException {
		int result = donationDAO.update(donationDTO);
		if(result==0) throw new SQLException("수정 실패했습니다.");
	}

	@Override
	public void delete(int donCode) throws SQLException {
		int result = donationDAO.delete(donCode);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
	}

}
