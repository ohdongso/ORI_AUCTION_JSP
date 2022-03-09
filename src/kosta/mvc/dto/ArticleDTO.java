package kosta.mvc.dto;

public class ArticleDTO {
	private int atcCode;
	private String atcTitle;
	private String atcContents;
	private String atcRdate;
	private String atcUrl;
	
	//페이지처리
	private int pageCnt;
	
	public ArticleDTO() {}
	
	public ArticleDTO(int atcCode, String atcTitle, String atcContents, String atcRdate, String atcUrl) {
		super();
		this.atcCode = atcCode;
		this.atcTitle = atcTitle;
		this.atcContents = atcContents;
		this.atcRdate = atcRdate;
		this.atcUrl = atcUrl;
	}
	public int getAtcCode() {
		return atcCode;
	}
	public void setAtcCode(int atcCode) {
		this.atcCode = atcCode;
	}
	public String getAtcTitle() {
		return atcTitle;
	}
	public void setAtcTitle(String atcTitle) {
		this.atcTitle = atcTitle;
	}
	public String getAtcContents() {
		return atcContents;
	}
	public void setAtcContents(String atcContents) {
		this.atcContents = atcContents;
	}
	public String getAtcRdate() {
		return atcRdate;
	}
	public void setAtcRdate(String atcRdate) {
		this.atcRdate = atcRdate;
	}
	public String getAtcUrl() {
		return atcUrl;
	}
	public void setAtcUrl(String atcUrl) {
		this.atcUrl = atcUrl;
	}
	
	
}
