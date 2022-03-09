package kosta.mvc.dto;

import java.util.List;

public class ReviewBoardDTO {
	private int reviewCode;
	private int artCode;
	private String id;
	private String reviewTitle;
	private String reviewContents;
	private String reviewDate;
	private int reviewView;
	private int reviewRate;
	private ArtDTO art;
	private List<ReviewBoardReplyDTO> reply;
	
	
	public ReviewBoardDTO() {}

	public ReviewBoardDTO(int reviewCode, int artCode, String id, String reviewTitle, String reviewContents,
			String reviewDate, int reviewView, int reviewRate) {
		super();
		this.reviewCode = reviewCode;
		this.artCode = artCode;
		this.id = id;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
		this.reviewView = reviewView;
		this.reviewRate = reviewRate;
	}

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public int getArtCode() {
		return artCode;
	}

	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewView() {
		return reviewView;
	}

	public void setReviewView(int reviewView) {
		this.reviewView = reviewView;
	}

	public int getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}

	public ArtDTO getArt() {
		return art;
	}

	public void setArt(ArtDTO art) {
		this.art = art;
	}

	public List<ReviewBoardReplyDTO> getReply() {
		return reply;
	}

	public void setReply(List<ReviewBoardReplyDTO> reply) {
		this.reply = reply;
	}
}
