package kosta.mvc.dto;

public class BoardReplyDTO {
	private int boardReplyCode;
	private String id;
	private int boardCode;
	private String boardReplyContent;
	private String boardReplyRdate;
	
	public BoardReplyDTO() {}
	
	public BoardReplyDTO(int boardReplyCode, String id, int boardCode, String boardReplyContent, String boardReplyRdate) {
		super();
		this.boardReplyCode = boardReplyCode;
		this.id = id;
		this.boardCode = boardCode;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyRdate = boardReplyRdate;
	}
	
	
	public int getBoardReplyCode() {
		return boardReplyCode;
	}
	public void setBoardReplyCode(int boardReplyCode) {
		this.boardReplyCode = boardReplyCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardReplyContent() {
		return boardReplyContent;
	}
	public void setBoardReplyContent(String boardReplyContent) {
		this.boardReplyContent = boardReplyContent;
	}
	public String getBoardReplyRdate() {
		return boardReplyRdate;
	}
	public void setBoardReplyRdate(String boardReplyRdate) {
		this.boardReplyRdate = boardReplyRdate;
	}
	
	
}
