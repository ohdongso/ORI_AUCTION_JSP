package kosta.mvc.dao.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ConsignmentReplyDTO;
import kosta.mvc.util.DbUtil;

public class ConsignmentReplyDAOImpl implements ConsignmentReplyDAO {

	@Override
	public int insertReply(ConsignmentReplyDTO reply) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO CONSIGNMENT_REPLY VALUES(CONSIGN_R_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reply.getConsignCode());
			ps.setString(2, reply.getUserId());
			ps.setString(3, reply.getConsignReplyContents());
			this.updateState(reply.getConsignCode());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public void updateState(int consignCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "UPDATE CONSIGNMENT SET CONSIGN_STATE=2 WHERE CONSIGN_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, consignCode);
			ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
	}
	
	

}
