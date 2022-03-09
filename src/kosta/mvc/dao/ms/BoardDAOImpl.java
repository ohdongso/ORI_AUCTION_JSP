package kosta.mvc.dao.ms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.BoardDTO;
import kosta.mvc.paging.PageCnt;
import kosta.mvc.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardDTO> selectAll(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql= "SELECT ID, BOARD_CODE, BOARD_CATEGORY, BOARD_TITLE, BOARD_CONTENTS, TO_CHAR(BOARD_RDATE, 'YYYY-MM-DD HH24:MI:SS'),BOARD_VIEWS, BOARD_FILE FROM (select a.*,ROWNUM rnum from(select * from board order by board_rdate desc)a) where rnum <=? and rnum >=?";
		try {
			
			//전체 레코드수 가져오기 
			int totalCount = getSelectTotalCount(); 
			
			
			PageCnt page= new PageCnt(); 
			//전체 페이지수 구한다. ( EX) 전체게시물수 /한페이지당보여줄게시물수 -> 최종결과 올림
			page.setPageCnt(totalCount % page.getPagesize() == 0 ? totalCount / page.getPagesize() : totalCount / page.getPagesize() + 1);
			page.setPageNo(pageNo);
			
			con = DbUtil.getConnection();
			// 총 레코드수를 가져오기
			ps= con.prepareStatement(sql);
			ps.setInt(1, pageNo * page.getPagesize() );  // 3 *5    --> 15
			ps.setInt(2, (pageNo - 1) * page.getPagesize() + 1); // (3-1) *5 + 1    -->11

			// 게시물 가져오기
	        rs = ps.executeQuery();
			while (rs.next()) {
					BoardDTO board =new BoardDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7), rs.getString(8));
					
					list.add(board);
					
		    } // while 끝..
			
			

		}finally{
	   DbUtil.dbClose(rs, ps, con);
	}

   return list;
}

	@Override
	public BoardDTO selectByBoardCode(int boardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTO result = null;

		String sql = "select * from board where board_code=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new BoardDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7), rs.getString(8));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);

		}
		return result;
	}

	@Override
	public int increamentByViews(int boardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "update board set board_views=board_views+1 where board_code=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);

		}

		return result;
	}

	@Override
	public List<BoardDTO> searchByKeyField(String keyField, String keyWord) throws SQLException {	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql="SELECT * FROM BOARD ";
		try {
			switch (keyField) {
			case "title":
				sql+="WHERE board_title like ?";
				break;
			case "content":
				sql+="WHERE board_contents like ?";
				break;
			case "id":
				sql+="WHERE ID like ?";
				break;
			}
			sql+="ORDER BY board_category";
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs= ps.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7), rs.getString(8));
				list.add(board);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<BoardDTO> searchByCategory(int boardCategory) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select id, board_code, board_category, board_title, board_contents, TO_CHAR(board_rDATE, 'YYYY-MM-DD HH24:MI:SS'), board_views, board_file from board where  board_category = ? order by board_rdate";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7), rs.getString(8));
				list.add(board);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES(?,BOARD_SEQ.NEXTVAL,?,?,?,DEFAULT,?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getId());
			ps.setInt(2, boardDTO.getBoardCategory());
			ps.setString(3, boardDTO.getBoardTitle());
			ps.setString(4, boardDTO.getBoardContent());
			ps.setInt(5, boardDTO.getViews());
			ps.setString(6, boardDTO.getFile());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE BOARD SET BOARD_CATEGORY= ?, BOARD_TITLE = ?, BOARD_CONTENTS=?, BOARD_FILE=?  WHERE BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardDTO.getBoardCategory());
			ps.setString(2, boardDTO.getBoardTitle());
			ps.setString(3, boardDTO.getBoardContent());
			ps.setString(4, boardDTO.getFile());
			ps.setInt(5, boardDTO.getBoardCode());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int boardCode,String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			ps.setString(2,id);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int deleteAdmin(int boardCode, String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * 전체 게시물수 
	 * */
    public int getSelectTotalCount() throws SQLException{
    	Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		int result=0;
		
		String sql="select count(*) from BOARD";
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
