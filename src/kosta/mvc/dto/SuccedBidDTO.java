package kosta.mvc.dto;

public class SuccedBidDTO {

	private int sucBidCode;
	private int aucCode;
	private String id;
	private int artCode;
	private String sucBidDate;
	private int sucBidCost;
	private int sucBidState;
	
	public SuccedBidDTO() {}

	public SuccedBidDTO(int sucBidCode, int aucCode, String id, int artCode, String sucBidDate, int sucBidCost, int sucBidState) {
		this.sucBidCode = sucBidCode;
		this.aucCode = aucCode;
		this.id = id;
		this.artCode = artCode;
		this.sucBidDate = sucBidDate;
		this.sucBidCost = sucBidCost;
		this.sucBidState = sucBidState;
	}

	public int getSucBidCode() {
		return sucBidCode;
	}

	public void setSucBidCode(int sucBidCode) {
		this.sucBidCode = sucBidCode;
	}

	public int getAucCode() {
		return aucCode;
	}

	public void setAucCode(int aucCode) {
		this.aucCode = aucCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getArtCode() {
		return artCode;
	}

	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}

	public String getSucBidDate() {
		return sucBidDate;
	}

	public void setSucBidDate(String sucBidDate) {
		this.sucBidDate = sucBidDate;
	}

	public int getSucBidCost() {
		return sucBidCost;
	}

	public void setSucBidCost(int sucBidCost) {
		this.sucBidCost = sucBidCost;
	}

	public int getSucBidState() {
		return sucBidState;
	}

	public void setSucBidState(int sucBidState) {
		this.sucBidState = sucBidState;
	}
	
	
}
