package kosta.mvc.dto;

public class ReviewBoardReplyDTO {
	private int reviewReplyCode;
	private String id;
	private int reviewCode;
	private String reviewReplyContents;
	private String reviewReplyDate;
	
	public ReviewBoardReplyDTO() {}
	public ReviewBoardReplyDTO(int reviewReplyCode,  int reviewCode, String id, String reviewReplyContents,
			String reviewReplyDate) {
		super();
		this.reviewReplyCode = reviewReplyCode;
		this.id = id;
		this.reviewCode = reviewCode;
		this.reviewReplyContents = reviewReplyContents;
		this.reviewReplyDate = reviewReplyDate;
	}
	public int getReviewReplyCode() {
		return reviewReplyCode;
	}
	public void setReviewReplyCode(int reviewReplyCode) {
		this.reviewReplyCode = reviewReplyCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getReviewReplyContents() {
		return reviewReplyContents;
	}
	public void setReviewReplyContents(String reviewReplyContents) {
		this.reviewReplyContents = reviewReplyContents;
	}
	public String getReviewReplyDate() {
		return reviewReplyDate;
	}
	public void setReviewReplyDate(String reviewReplyDate) {
		this.reviewReplyDate = reviewReplyDate;
	}
	
}
