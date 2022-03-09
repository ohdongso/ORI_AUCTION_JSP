package kosta.mvc.dao.ds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.AuctionDTO;
import kosta.mvc.dto.BiddingDTO;
import kosta.mvc.util.DbUtil;

public class AuctionDAOImpl implements AuctionDAO {
	/**
	 * 전체경매
	 * */
	@Override
	public List<AuctionDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AuctionDTO> list = new ArrayList<>();
	
		String sql = "select auc_code, art_code, first_cost, auc_category, auc_state, to_char(auc_date, 'YYYY') from auction where auc_state = 1 order by auc_code desc";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AuctionDTO auctionDTO = new AuctionDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				list.add(auctionDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * 경매중인 작품조회
	 * */
	@Override
	public ArtDTO auctionArtSearch(AuctionDTO auctionDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO artDTO = null;
		String sql = "select * from arts join auction using(art_code) where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, auctionDTO.getAucCode());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				artDTO = new ArtDTO(rs.getInt("art_code"), rs.getString("id"), rs.getString("art_name"),
						rs.getString("artist_Name"), rs.getInt("art_Category"), rs.getInt("art_State"), rs.getInt("art_Size_Height"), rs.getInt("art_Size_Width"),
						rs.getInt("art_Size_Vol"), rs.getInt("estimate_Cost"),  (rs.getString("prd_Year").substring(0, 4)), rs.getString("art_Detail"), rs.getString("art_Img"));
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return artDTO;
	}
	
	/**
	 * (일반, 제로베이스, 자선)경매 검색
	 * */
	@Override
	public List<AuctionDTO> selectAuction(int aucCategory) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AuctionDTO> list = new ArrayList<>();
		String sql = "select * from auction where auc_state = 1 and auc_category = ? order by auc_code desc";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCategory);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AuctionDTO auctionDTO = new AuctionDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				
				list.add(auctionDTO);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return list;
	}
	
	/**
	 * 조건 경매검색
	 * */
	@Override
	public List<ArtDTO> searchByAuction(String keyField, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> list = new ArrayList<>();
		String sql = "select * from arts join auction using(art_code) ";
		
		try {
			switch (keyField) {
			case "artistName":
				sql += "where artist_name = ?";
				break;
			case "artName":
				sql += "where art_name = ?";
				break;
			case "artCode":
				sql += "where art_code = ?";
				break;
			}
			sql += "order by auc_code desc";
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			if(keyField.equals("art_code")) {
				ps.setInt(1, Integer.parseInt(keyWord));
			} else {
				ps.setString(1, keyWord);
			}
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ArtDTO artDTO = new ArtDTO(rs.getInt("art_code"), rs.getString("id"), rs.getString("art_name"),
						rs.getString("artist_Name"), rs.getInt("art_Category"), rs.getInt("art_State"), rs.getInt("art_Size_Height"), rs.getInt("art_Size_Width"),
						rs.getInt("art_Size_Vol"), rs.getInt("estimate_Cost"), rs.getString("prd_Year"), rs.getString("art_Detail"), rs.getString("art_Img"));
				
				list.add(artDTO);		
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return list;
	}
	
	/**
	 * 조건 경매검색(min, max)
	 * */
	@Override
	public List<ArtDTO> searchMinMax(int min, int max) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> list = new ArrayList<>();
		String sql = "select * from arts join auction using(art_code) where auc_state = 1 and estimate_cost between ? and ? order by auc_code desc";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, min);
			ps.setInt(2, max);	
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ArtDTO artDTO = new ArtDTO(rs.getInt("art_code"), rs.getString("id"), rs.getString("art_name"),
						rs.getString("artist_Name"), rs.getInt("art_Category"), rs.getInt("art_State"), rs.getInt("art_Size_Height"), rs.getInt("art_Size_Width"),
						rs.getInt("art_Size_Vol"), rs.getInt("estimate_Cost"), rs.getString("prd_Year"), rs.getString("art_Detail"), rs.getString("art_Img"));
				
				list.add(artDTO);		
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return list;
	}

	/**
	 * 작품 상세보기
	 * */
	@Override
	public ArtDTO selectDetailArt(int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO artDTO = null;
		
		String sql = "select * from arts where art_code = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				artDTO = new ArtDTO(rs.getInt("art_code"), rs.getString("id"), rs.getString("art_name"),
						rs.getString("artist_Name"), rs.getInt("art_Category"), rs.getInt("art_State"), rs.getInt("art_Size_Height"), rs.getInt("art_Size_Width"),
						rs.getInt("art_Size_Vol"), rs.getInt("estimate_Cost"), rs.getString("prd_Year"), rs.getString("art_Detail"), rs.getString("art_Img"));
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return artDTO;
	}
	
	/**
	 * 작품코드로 경매코드 가져오기
	 */
	@Override
	public int selectDetailAucCode(int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int aucCode = 0;
		
		String sql = "select * from auction join arts using(art_code) where art_code = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			
			rs = ps.executeQuery();	
			
			if(rs.next()) {
				aucCode = rs.getInt("auc_code");
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return aucCode;
		
	}

	/**
	 * 경매관리 페이지를 클릭했을 때, 경매에 대한 정보를 보여주는 메소드
	 * */
	@Override
	public List<AuctionDTO> adminSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AuctionDTO> list = new ArrayList<>();
		String sql = "select auc_code, art_code, first_cost, auc_category, auc_state, to_char(auc_date, 'YYYY-MM-DD'), to_char(auc_date + 10, 'YYYY-MM-DD') from auction order by auc_date desc";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				AuctionDTO auctionDTO = new AuctionDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				auctionDTO.setExitDate(rs.getString(7));
				auctionDTO.setArt(this.getArt(rs.getInt("art_code")));
				auctionDTO.setBid(this.getBid(rs.getInt("auc_code")));
				auctionDTO.setMaxCost(this.getMaxCost(rs.getInt("auc_code")));
				
				list.add(auctionDTO);
			}
					
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}
	
	/**
	 * 경매 카테고리 검색
	 * */
	@Override
	public List<AuctionDTO> searchByState(int state) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AuctionDTO> list = new ArrayList<>();
		String sql = "";
		
		if(state == 3) {
			sql = "select auc_code, art_code, first_cost, auc_category, auc_state, to_char(auc_date, 'YYYY-MM-DD'), to_char(auc_date + 10, 'YYYY-MM-DD') from auction where auc_state = ? or auc_state = 4 order by auc_date desc";	
		} else {
			sql = "select auc_code, art_code, first_cost, auc_category, auc_state, to_char(auc_date, 'YYYY-MM-DD'), to_char(auc_date + 10, 'YYYY-MM-DD') from auction where auc_state = ? order by auc_date desc";
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, state);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				// SQL에서 출력되는 컬럼을 하나더 설정하고, DTO에 변수를 만들어 저장해줬다.
				AuctionDTO auctionDTO = new AuctionDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				auctionDTO.setExitDate(rs.getString(7));
				auctionDTO.setArt(this.getArt(rs.getInt("art_code")));
				auctionDTO.setBid(this.getBid(rs.getInt("auc_code")));
				auctionDTO.setMaxCost(this.getMaxCost(rs.getInt("auc_code")));
				
				list.add(auctionDTO);
			}
					
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}
		
	/**
	 * 응찰 내역에서 최고가를 뽑아내는 구문.
	 * */
	@Override
	public int getMaxCost(int aucCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select max(bid_cost) from bidding where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
	/**
	 * 낙찰버튼을 클릭했을 때, 최고 낙찰가에 대한 id를 반환해주는 메소드
	 * ;
	 * */
	@Override
	public String getMaxCostId(int aucCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = "";
		String sql = "select * from bidding where bid_cost = (select max(bid_cost) from bidding where auc_code = ?) and auc_code=? order by bid_date ";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			ps.setInt(2, aucCode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return id;
	}
	
	
	/**
	 * 경매코드에 해당하는 작품 정보가져오기
	 * */
	@Override
	public ArtDTO getArt(int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO art = null;
		String sql="SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, ESTIMATE_COST, TO_CHAR(PRD_YEAR, 'YYYY'), ART_DETAIL, ART_IMG FROM ARTS WHERE art_code=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				art = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return art;
	}
	
	/**
	 * 경매코드에 해당하는 응찰 가져오기
	 * */
	@Override
	public List<BiddingDTO> getBid(int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BiddingDTO> list = new ArrayList<BiddingDTO>();
		
		// DTO객체에 저장될 정보
		String sql = "select bid_code, auc_code, id, art_code, bid_cost, to_char(bid_date, 'YYYY-MM-DD HH24:MI:SS') from bidding where auc_code = ? order by bid_cost";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			rs= ps.executeQuery();
			
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
	 * 진행중인 경매 경매종료 기능
	 * */
	@Override
	public List<AuctionDTO> endAuction(int aucCode, int state) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AuctionDTO> auctionDTOList = null;
		int result = 0;
		String sql = "update auction set auc_state = 3 where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			
			result = ps.executeUpdate();
				
			auctionDTOList = searchByState(state);	
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return auctionDTOList;
	}
	
	/**
	 * 예정경매 개시하는 기능
	 */
	@Override
	public List<AuctionDTO> startAuction(int aucCode, int state) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AuctionDTO> auctionDTOList = null;
		int result = 0;
		String sql = "update auction set auc_state = 1 where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			
			result = ps.executeUpdate();
			auctionDTOList = searchByState(state);
			
		} finally {
			DbUtil.dbClose(ps, con);
		}	
		return auctionDTOList;
	}
	
	/**
	 * 경매 수정시, updateAuction.jsp까지 정보를 전달 하는 기능
	 * aucCode에 해당하는 정보가져오기
	 * */
	@Override
	public AuctionDTO updateForm(int aucCode, int aucState, int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AuctionDTO auctionDTO = null;
		String sql = "select * from auction where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				auctionDTO = new AuctionDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				auctionDTO.setArt(this.getArt(rs.getInt("art_code")));
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return auctionDTO;
	}
	
	/**
	 * 경매수정
	 * */
	@Override
	public List<AuctionDTO> updateAuction(int aucCode, int aucState, int artCode, int updateStartCose) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AuctionDTO> auctionDTOList = null;
		int result = 0;
		String sql = "update auction set first_cost = ? where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, updateStartCose);
			ps.setInt(2, aucCode);
			
			result = ps.executeUpdate();
			
			// Auction기본 컬럼, art, bid, 최고값 저장.
			auctionDTOList = searchByState(aucState);
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return auctionDTOList;
	}
	
	/**
	 * 경매삭제
	 * */
	@Override
	public List<AuctionDTO> deleteAuction(int aucCode, int aucState, int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AuctionDTO> auctionDTOList = null;
		int result = 0;
		String sql = "delete from auction where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			
			result = ps.executeUpdate();
			
			// Auction기본 컬럼, art, bid, 최고값 저장.
			auctionDTOList = searchByState(aucState);
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return auctionDTOList;
	}
	
	/**
	 * 종료된 경매, 낙찰하는기능
	 * */
	@Override
	public int insertSuccedBid(int aucCode, int aucState, int artCode, String id, int maxCost) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into succed_bid values(SUC_SEQ.NEXTVAL, ?, ?, ?, default, ?, 1)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// 종료된 경매에 옥션코드
			ps.setInt(1, aucCode);
			
			// 최종응찰된 사람의 ID
			ps.setString(2, id);
			
			// 종료된 경매에 대한 작품코드
			ps.setInt(3, artCode);
			
			// 해당 경매에서, 응찰된 가격중 최고가(낙찰가)
			ps.setInt(4, maxCost);
			
			result = ps.executeUpdate();
			
			// Auction기본 컬럼, art, bid, 최고값 저장. ==> controller에서 수정해주자.
			// auctionDTOList = searchByState(aucState);
	
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 낙찰된 경매의 상태를 5번 낙찰진행 상태로 변경하는 기능
	 */
	@Override
	public List<AuctionDTO> updateAuctionState(int aucCode, int artCode, int aucState) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AuctionDTO> auctionDTOList = null;
		int result = 0;
		String sql = "update auction set auc_state = 5 where auc_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, aucCode);
			
			result = ps.executeUpdate();
			
			// Auction기본 컬럼, art, bid, 최고값 저장.
			auctionDTOList = searchByState(aucState);
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return auctionDTOList;
	}
		
	@Override
	public int insertScheduledAuction(int artCode, int startCost, int aucCategory) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		// "insert into auction values(AUCTION_SEQ.NEXTVAL, /// 작품코드, 경매시작가, 경매카테고리() ///, 경매상태(2), 경매시작일)";

		String sql = "insert into auction values(AUCTION_SEQ.NEXTVAL, ?, ?, ?, 2, default)";
					
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, artCode);
			
			if(aucCategory == 3) {
				ps.setInt(2, 0);
			} else {
				ps.setInt(2, startCost);
			}
			
			ps.setInt(3, aucCategory);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}	
}