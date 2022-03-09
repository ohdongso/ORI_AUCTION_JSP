package kosta.mvc.dao.ms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArticleDTO;
import kosta.mvc.dto.BoardDTO;
import kosta.mvc.paging.PageCnt;
import kosta.mvc.util.DbUtil;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public List<ArticleDTO> selectAll(int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArticleDTO> list = new ArrayList<ArticleDTO>();
		String sql = "select  atc_code, atc_title, atc_contents, TO_CHAR(atc_rDATE, 'YYYY-MM-DD HH24:MI:SS'), atc_url from (select a.*,ROWNUM rnum from(select * from article order by atc_rdate desc)a) where rnum <=? and rnum >=?";
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
			
			//게시물 가져오기
			rs = ps.executeQuery();
			while (rs.next()) {
				ArticleDTO article = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(article);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	
	@Override
	public ArticleDTO selectByAtcCode(int atcCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArticleDTO result = null;

		String sql = "select * from article where atc_code=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, atcCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new ArticleDTO(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);

		}
		return result;
	}
	

	@Override
	public int insert(ArticleDTO articleDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO ARTICLE VALUES(ARTI_SEQ.NEXTVAL,?,?,DEFAULT,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, articleDTO.getAtcTitle());
			ps.setString(2, articleDTO.getAtcContents());
			ps.setString(3, articleDTO.getAtcUrl());
			

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(ArticleDTO articleDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE article SET ATC_TITLE = ?, ATC_CONTENTS=?, ATC_URL=? WHERE ATC_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, articleDTO.getAtcTitle());
			ps.setString(2, articleDTO.getAtcContents());
			ps.setString(3, articleDTO.getAtcUrl());
			ps.setInt(4, articleDTO.getAtcCode());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	
	}

	@Override
	public int delete(int atcCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM ARTICLE WHERE ATC_CODE = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, atcCode);
				
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
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
		
		String sql="select count(*) from article";
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
