package kosta.mvc.dao.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.FaqDTO;
import kosta.mvc.util.DbUtil;

public class FAQDAOImpl implements FAQDAO {

	@Override
	public List<FaqDTO> selectAll() throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<FaqDTO> list = new ArrayList<FaqDTO>();
		String sql = "SELECT * FROM FAQ ORDER BY FAQ_CATEGORY";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				list.add(new FaqDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public FaqDTO selectByFaqCode(int faqCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqDTO> searchByCategory(int category) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<FaqDTO> list = new ArrayList<FaqDTO>();
		String sql = "SELECT * FROM FAQ WHERE FAQ_CATEGORY=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, category);
			rs= ps.executeQuery();
			while(rs.next()) {
				list.add(new FaqDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insert(FaqDTO faq) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO FAQ VALUES(FAQ_SEQ.NEXTVAL,?,?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, faq.getFaqCategory());
			ps.setString(2, faq.getFaqTitle());
			ps.setString(3, faq.getFaqContents());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(FaqDTO faq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int faqCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "DELETE FROM FAQ WHERE FAQ_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, faqCode);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
