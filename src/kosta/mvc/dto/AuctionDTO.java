package kosta.mvc.dto;

import java.util.List;

public class AuctionDTO {
	private int aucCode;
	private int artCode;
	private int firstCost;
	private int aucCategory;
	private int aucState;
	private String aucRdate;
	private String exitDate;
	private int maxCost;
	private ArtDTO art;
	private List<BiddingDTO> bid;
	
	public AuctionDTO() {};
	public AuctionDTO(int aucCode, int artCode, int firstCost, int aucCategory, int aucState, String aucRdate) {
		super();
		this.aucCode = aucCode;
		this.artCode = artCode;
		this.firstCost = firstCost;
		this.aucCategory = aucCategory;
		this.aucState = aucState;
		this.aucRdate = aucRdate;
	}
	
	
	public int getMaxCost() {
		return maxCost;
	}
	public void setMaxCost(int maxCost) {
		this.maxCost = maxCost;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public int getAucCode() {
		return aucCode;
	}
	public void setAucCode(int aucCode) {
		this.aucCode = aucCode;
	}
	public int getArtCode() {
		return artCode;
	}
	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}
	public int getFirstCost() {
		return firstCost;
	}
	public void setFirstCost(int firstCost) {
		this.firstCost = firstCost;
	}
	public int getAucCategory() {
		return aucCategory;
	}
	public void setAucCategory(int aucCategory) {
		this.aucCategory = aucCategory;
	}
	public int getAucState() {
		return aucState;
	}
	public void setAucState(int aucState) {
		this.aucState = aucState;
	}
	public String getAucRdate() {
		return aucRdate;
	}
	public void setAucRdate(String aucRdate) {
		this.aucRdate = aucRdate;
	}
	public ArtDTO getArt() {
		return art;
	}
	public void setArt(ArtDTO art) {
		this.art = art;
	}
	public List<BiddingDTO> getBid() {
		return bid;
	}
	public void setBid(List<BiddingDTO> bid) {
		this.bid = bid;
	}
}