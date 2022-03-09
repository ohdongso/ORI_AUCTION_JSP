package kosta.mvc.dto;

public class DonationDTO {
	
	private int donCode;
	private String donTitle;
	private String donContent;
	private String donDate;
	private String donRdate;
	private String donImg;
	
	public DonationDTO() {}
	
	public DonationDTO(int donCode, String donTitle, String donContent, String donDate, String donRdate) {
		super();
		this.donCode = donCode;
		this.donTitle = donTitle;
		this.donContent = donContent;
		this.donDate = donDate;
		this.donRdate = donRdate;
	}

	public int getDonCode() {
		return donCode;
	}

	public void setDonCode(int donCode) {
		this.donCode = donCode;
	}

	public String getDonTitle() {
		return donTitle;
	}

	public void setDonTitle(String donTitle) {
		this.donTitle = donTitle;
	}

	public String getDonContent() {
		return donContent;
	}

	public void setDonContent(String donContent) {
		this.donContent = donContent;
	}

	public String getDonDate() {
		return donDate;
	}

	public void setDonDate(String donDate) {
		this.donDate = donDate;
	}

	public String getDonRdate() {
		return donRdate;
	}

	public void setDonRdate(String donRdate) {
		this.donRdate = donRdate;
	}

	public String getDonImg() {
		return donImg;
	}

	public void setDonImg(String donImg) {
		this.donImg = donImg;
	}


}
