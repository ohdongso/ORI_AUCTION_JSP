package kosta.mvc.dto;

public class BiddingDTO {
	
	private int bidCode;
	private int aucCode;
	private String id;
	private int artCode;
	private int bidCost;
	private String bidRegDate;
	private int aucState;
	
	public BiddingDTO() {}

	public BiddingDTO(int bidCode, int aucCode, String id, int artCode, int bidCost, String bidRegDate) {
		this.bidCode = bidCode;
		this.aucCode = aucCode;
		this.id = id;
		this.artCode = artCode;
		this.bidCost = bidCost;
		this.bidRegDate = bidRegDate;
	}

//	public BiddingDTO(int bidCode, int aucCode, String id, int artCode, int bidCost, String bidRegDate, int artState) {
//		this(bidCode, aucCode, id, artCode, bidCost, bidRegDate);
//		this.artState = artState;
//	}

	public int getBidCode() {
		return bidCode;
	}

	public void setBidCode(int bidCode) {
		this.bidCode = bidCode;
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

	public int getBidCost() {
		return bidCost;
	}

	public void setBidCost(int bidCost) {
		this.bidCost = bidCost;
	}

	public String getBidRegDate() {
		return bidRegDate;
	}

	public void setBidRegDate(String bidRegDate) {
		this.bidRegDate = bidRegDate;
	}

	public int getAucState() {
		return aucState;
	}

	public void setAucState(int aucState) {
		this.aucState = aucState;
	}
	
	
}
