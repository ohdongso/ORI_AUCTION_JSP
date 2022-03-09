package kosta.mvc.dao.dh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.BiddingDTO;
import kosta.mvc.dto.SuccedBidDTO;
import kosta.mvc.util.DbUtil;

public class BiddingDAOImpl implements BiddingDAO {

	/**
	 * 응찰하기 (insertBid)
	 *  - 회원아이디, 옥션코드, 작품코드, 금액, 응찰시간을 전달받아서 DB등록.
	 * */
	@Override
	public int insertBid(BiddingDTO biddingDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO BIDDING VALUES (BIDDING_SEQ.NEXTVAL,?,?,?,?,SYSDATE)"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, biddingDTO.getAucCode());
			ps.setString(2, biddingDTO.getId());
			ps.setInt(3, biddingDTO.getArtCode());
			ps.setInt(4, biddingDTO.getBidCost());

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	/**
	 * 전체 응찰 검색
	 * */
	@Override
	public List<BiddingDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BiddingDTO> list = new ArrayList<BiddingDTO>();
		String sql = "SELECT BID_CODE, AUC_CODE, ID, BIDDING.ART_CODE, BID_COST, BID_DATE, "
				+ "AUC_STATE FROM BIDDING JOIN AUCTION USING(AUC_CODE) ORDER BY BID_CODE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				BiddingDTO biddingDTO = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
				biddingDTO.setAucState(rs.getInt(7));
				list.add(biddingDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}
	
	/**
	 * 경매코드와 ID로 중복 응찰 확인
	 */
	@Override
	public BiddingDTO checkByAucCodeId(int aucCode, String loginUser) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BiddingDTO biddingDTO = null;
		
		String sql = "SELECT * FROM BIDDING WHERE AUC_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			ps.setString(2, loginUser);
			rs = ps.executeQuery();
			if(rs.next()) {
				biddingDTO = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return biddingDTO;
	}

	/**
	 * 응찰코드로 응찰 내역 검색하기
	 */
	@Override
	public BiddingDTO selectByBidCode(int bidCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 경매 코드로 응찰 리스트 검색해서 정렬해서 전달 (응찰가)
	 *  - 경매에 몇 명의 회원들이 응찰했는지 확인할 때 
	 * */
	@Override
	public List<BiddingDTO> selectBidByAucCode(int aucCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BiddingDTO> list = new ArrayList<BiddingDTO>();
		
		String sql = "SELECT BID_CODE, AUC_CODE, ID, BIDDING.ART_CODE, BID_COST, BID_DATE, "
				+ "AUC_STATE FROM BIDDING JOIN AUCTION USING(AUC_CODE) WHERE AUC_CODE=? ORDER BY BID_COST DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				BiddingDTO biddingDTO = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
				biddingDTO.setAucState(rs.getInt(7));
				list.add(biddingDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}

	/**
	 * 회원 ID로 응찰 리스트 검색
	 *  - 로그인한 회원이 응찰한 작품을 찾아서 '나의 응찰 내역'에 리스트 전송할 때
	 *  - 회원이 응찰에 대한 수정/삭제를 요구할 때
	 * */
	@Override
	public List<BiddingDTO> selectBidByUserId(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BiddingDTO> list = new ArrayList<BiddingDTO>();
		
		String sql = "SELECT * FROM BIDDING WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				BiddingDTO biddingDTO = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(biddingDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}

	/**
	 * 회원 ID로 회원이 참여한 경매의 응찰 정보와 작품 상태를 함께 가져오기
	 * */
	@Override
	public List<BiddingDTO> searchBidArtState(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BiddingDTO> list = new ArrayList<BiddingDTO>();
		
		String sql = "SELECT BID_CODE, AUC_CODE, ID, BIDDING.ART_CODE, BID_COST, BID_DATE, "
				+ "AUC_STATE FROM BIDDING JOIN AUCTION USING(AUC_CODE) WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				BiddingDTO biddingDTO = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
				biddingDTO.setAucState(rs.getInt(7));
				list.add(biddingDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}
	
	/**
	 * 경매코드로 해당 경매에 가장 많은 금액을 먼저 응찰한 사용자를 찾기
	 * */
	@Override
	public BiddingDTO selectTopBid(int aucCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BiddingDTO topBid = null;
		
		String sql = "SELECT MIN(BID_CODE) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS BID_CODE,"
				+ " MIN(AUC_CODE) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS AUC_CODE,"
				+ " MAX(ID) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS ID,"
				+ " MIN(ART_CODE) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS ART_CODE,"
				+ " MIN(BID_COST) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS BID_COST,"
				+ " MIN(to_char(BID_DATE,'YYYY-MM-DD HH24:MI:SS')) KEEP(DENSE_RANK FIRST ORDER BY BID_COST DESC) AS BID_DATE"
				+ " FROM BIDDING where AUC_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				topBid = new BiddingDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return topBid;
	}

	/**
	 * 작품 코드로 응찰 리스트 검색
	 *  - 작품 상세에서 응찰 현황 파악할 때 
	 * */
	@Override
	public List<BiddingDTO> selectBidByArtCode(int artCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 응찰가 수정
	 *  - 회원의 요청에 따라 부득이하게 응찰 정보를 수정 해야할 때
	 *    ex) 금액을 잘못 입력했을 때
	 * */
	@Override
	public int updateBid(BiddingDTO biddingDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "UPDATE BIDDING SET BID_COST=? WHERE BID_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, biddingDTO.getBidCost());
			ps.setInt(2, biddingDTO.getBidCode());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * 응찰내역 삭제 -- by관리자
	 *  - 회원의 요청에 따라 부득이하게 응찰 취소를 해야할 때
	 *    ex) 작품 정보를 잘 못 이해한 상태에서 응찰을 했을 때
	 * */
	@Override
	public int deleteBid(int bidCode, String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "DELETE BIDDING WHERE BID_CODE=? AND ID=?"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bidCode);
			ps.setString(2, id);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	
}
