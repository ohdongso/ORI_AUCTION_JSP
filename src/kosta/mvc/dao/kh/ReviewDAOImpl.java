package kosta.mvc.dao.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.paging.PageCnt;
import kosta.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public List<ReviewBoardDTO> selectAll(int pageNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<ReviewBoardDTO> list = new ArrayList<ReviewBoardDTO>();
		String sql = "SELECT REVIEW_CODE, ID, REVIEW_TITLE, TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD HH24:MI:SS'), REVIEW_VIEWS, ART_CODE FROM (SELECT a.*, ROWNUM rnum"
				+ " FROM (SELECT * FROM REVIEW_BOARD ORDER BY REVIEW_DATE DESC)a) WHERE rnum <=? AND rnum>=?";
		try {
			int totalCount = getSelectTotalCount();
			PageCnt page = new PageCnt();
			page.setPageCnt(totalCount%page.getPagesize()==0? totalCount / page.getPagesize() : totalCount / page.getPagesize()+1);
			page.setPageNo(pageNo);

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageNo * page.getPagesize());
			ps.setInt(2, (pageNo - 1) * page.getPagesize() + 1); // (3-1) *5 + 1    -->11

			rs= ps.executeQuery();
			while(rs.next()) {
				ReviewBoardDTO review = new ReviewBoardDTO(rs.getInt(1), 0, rs.getString(2), rs.getString(3),null, rs.getString(4), rs.getInt(5), 0);
				review.setArt(this.getArt(rs.getInt(6)));
				list.add(review);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public ReviewBoardDTO selectByReviewCode(int reviewCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		ReviewBoardDTO result = null;
		String sql = "SELECT REVIEW_CODE, ART_CODE, ID, REVIEW_TITLE, REVIEW_CONTENT, TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD HH24:MI:SS'), REVIEW_VIEWS, REVIEW_RATE FROM REVIEW_BOARD WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				result = new ReviewBoardDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				result.setArt(this.getArt(rs.getInt(2)));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return result;
	}

	@Override
	public List<ReviewBoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewBoardDTO> list = new ArrayList<ReviewBoardDTO>();
		String sql="SELECT REVIEW_CODE, A.ID, REVIEW_TITLE, TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD HH24:MI:SS'), REVIEW_VIEWS, ART_CODE, ART_NAME FROM REVIEW_BOARD A JOIN ARTS B USING(ART_CODE) ";
		try {
			switch (keyField) {
			case "title":
				sql+="WHERE REVIEW_TITLE like ?";
				break;
			case "content":
				sql+="WHERE REVIEW_CONTENT like ?";
				break;
			case "writer":
				sql+="WHERE A.ID like ?";
				break;
			case "artName":
				sql+="WHERE ART_NAME LIKE ?";
				break;
			}
			sql+="ORDER BY REVIEW_DATE DESC";
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs= ps.executeQuery();
			while(rs.next()) {
				ReviewBoardDTO review = new ReviewBoardDTO(rs.getInt(1), 0, rs.getString(2), rs.getString(3),null, rs.getString(4), rs.getInt(5), 0);
				review.setArt(this.getArt(rs.getInt(6)));
				list.add(review);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int increamentViews(int reviewCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW_BOARD SET REVIEW_VIEWS = REVIEW_VIEWS+1 WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewCode);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int insert(ReviewBoardDTO review) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO REVIEW_BOARD VALUES(REVIEW_SEQ.NEXTVAL,?,?,?,?,DEFAULT,?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, review.getArtCode());
			ps.setString(2, review.getId());
			ps.setString(3, review.getReviewTitle());
			ps.setString(4, review.getReviewContents());
			ps.setInt(5, review.getReviewView());
			ps.setInt(6, review.getReviewRate());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public int update(ReviewBoardDTO review) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW_BOARD SET REVIEW_TITLE = ?, REVIEW_CONTENT=?, REVIEW_RATE=? WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, review.getReviewTitle());
			ps.setString(2, review.getReviewContents());
			ps.setInt(3, review.getReviewRate());
			ps.setInt(4, review.getReviewCode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public int delete(String id, int reviewCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM REVIEW_BOARD WHERE REVIEW_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewCode);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public ArtDTO getArt(int artCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO art = null;
		String sql="SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, ESTIMATE_COST, TO_CHAR(PRD_YEAR, 'YYYY'), ART_DETAIL, ART_IMG FROM ARTS WHERE ART_CODE=?";
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

	@Override
	public List<ArtDTO> getArtList(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> artList = new ArrayList<ArtDTO>();
		String sql="SELECT ART_CODE FROM SUCCED_BID JOIN MEMBER USING(ID) WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				int artCode = rs.getInt(1);
				artList.add(this.getArt(artCode));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return artList;
	}
	
	public int getSelectTotalCount() throws SQLException{
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		int result=0;
		
		String sql="select count(*) from review_board";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 값이 설정.
			
			rs = ps.executeQuery();
			if(rs.next()) {
				 result =rs.getInt(1);
			}			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return result;
	}
}
