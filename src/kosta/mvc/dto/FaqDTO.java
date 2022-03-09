package kosta.mvc.dto;

public class FaqDTO {
	private int faqCode;
	private int faqCategory;
	private String faqTitle;
	private String faqContents;
	
	public FaqDTO(){}

	public FaqDTO(int faqCode, int faqCategory, String faqTitle, String faqContents) {
		super();
		this.faqCode = faqCode;
		this.faqCategory = faqCategory;
		this.faqTitle = faqTitle;
		this.faqContents = faqContents;
	}

	public int getFaqCode() {
		return faqCode;
	}

	public void setFaqCode(int faqCode) {
		this.faqCode = faqCode;
	}

	public int getFaqCategory() {
		return faqCategory;
	}

	public void setFaqCategory(int faqCategory) {
		this.faqCategory = faqCategory;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContents() {
		return faqContents;
	}

	public void setFaqContents(String faqContents) {
		this.faqContents = faqContents;
	}
	
}
