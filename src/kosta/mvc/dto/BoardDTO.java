package kosta.mvc.dto;

import java.util.List;

public class BoardDTO {
	private int boardCode;
	private String id;
	private int boardCategory;
	private String boardTitle;
	private String boardContent;
	private int views;
	private String file;
	private String rdate;
	private List<BoardReplyDTO> reply;
	
	//페이지처리
	private int pageCnt;
	
	public BoardDTO() {}
	
	public BoardDTO(String id, int boardCode, int boardCategory, String boardTitle, String boardContent, String rdate, int views,
			String file) {
		super();
		this.boardCode = boardCode;
		this.id = id;
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.views = views;
		this.file = file;
		this.rdate = rdate;
	}




	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String date) {
		this.rdate = date;
	}

	public List<BoardReplyDTO> getReply() {
		return reply;
	}

	public void setReply(List<BoardReplyDTO> reply) {
		this.reply = reply;
	}

	
	
}
