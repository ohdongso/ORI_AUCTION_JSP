package kosta.mvc.dto;

public class ConsignmentReplyDTO {
	private int consignReplyCode;
	private int consignCode;
	private String userId;
	private String consignReplyContents;
	private String consignReplyRdate;
	
	public ConsignmentReplyDTO() {}
	public ConsignmentReplyDTO(int consignReplyCode, int consignCode, String userId, String consignReplyContents,
			String consignReplyRdate) {
		super();
		this.consignReplyCode = consignReplyCode;
		this.consignCode = consignCode;
		this.userId = userId;
		this.consignReplyContents = consignReplyContents;
		this.consignReplyRdate = consignReplyRdate;
	}

	public int getConsignReplyCode() {
		return consignReplyCode;
	}

	public void setConsignReplyCode(int consignReplyCode) {
		this.consignReplyCode = consignReplyCode;
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

	public String getConsignReplyContents() {
		return consignReplyContents;
	}

	public void setConsignReplyContents(String consignReplyContents) {
		this.consignReplyContents = consignReplyContents;
	}

	public String getConsignReplyRdate() {
		return consignReplyRdate;
	}

	public void setConsignReplyRdate(String consignReplyRdate) {
		this.consignReplyRdate = consignReplyRdate;
	}
}