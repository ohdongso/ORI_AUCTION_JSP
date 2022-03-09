package kosta.mvc.dto;

public class ConsignmentDTO {
	private int consignCode;
	private String userId;
	private int artCode;
	private String consignRdate;
	private int consignState;
	private int consignCategory;
	private ArtDTO art;
	private ConsignmentReplyDTO reply;
	
	public ConsignmentDTO() {}
	public ConsignmentDTO(int consignCode, String userId, int artCode, String consignRdate, int consignState, int consignCategory) {
		super();
		this.consignCode = consignCode;
		this.userId = userId;
		this.artCode = artCode;
		this.consignRdate = consignRdate;
		this.consignState = consignState;
		this.consignCategory = consignCategory;
	}
	public int getConsignCode() {
		return consignCode;
	}
	public void setConsignCode(int consignCode) {
		this.consignCode = consignCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getArtCode() {
		return artCode;
	}
	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}
	public String getConsignRdate() {
		return consignRdate;
	}
	public void setConsignRdate(String consignRdate) {
		this.consignRdate = consignRdate;
	}
	public int getConsignState() {
		return consignState;
	}
	public void setConsignState(int consignState) {
		this.consignState = consignState;
	}
	public ArtDTO getArt() {
		return art;
	}
	public void setArt(ArtDTO art) {
		this.art = art;
	}
	public ConsignmentReplyDTO getReply() {
		return reply;
	}
	public void setReply(ConsignmentReplyDTO reply) {
		this.reply = reply;
	}
	public int getConsignCategory() {
		return consignCategory;
	}
	public void setConsignCategory(int consignCategory) {
		this.consignCategory = consignCategory;
	}
	
}
