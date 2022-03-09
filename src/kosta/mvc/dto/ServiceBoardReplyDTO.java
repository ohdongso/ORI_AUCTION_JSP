package kosta.mvc.dto;

public class ServiceBoardReplyDTO {
	
	private int serviceReplyCode;
	private int serviceBoardCode;
	private String id;
	private String serviceReplyContent;
	private String serviceReplyDate;
	
	public ServiceBoardReplyDTO() {}
	
	public ServiceBoardReplyDTO(int serviceReplyCode, int serviceBoardCode, String id, String serviceReplyContent,
			String serviceReplyDate) {
		super();
		this.serviceReplyCode = serviceReplyCode;
		this.serviceBoardCode = serviceBoardCode;
		this.id = id;
		this.serviceReplyContent = serviceReplyContent;
		this.serviceReplyDate = serviceReplyDate;
	}

	public int getServiceReplyCode() {
		return serviceReplyCode;
	}

	public void setServiceReplyCode(int serviceReplyCode) {
		this.serviceReplyCode = serviceReplyCode;
	}

	public int getServiceBoardCode() {
		return serviceBoardCode;
	}

	public void setServiceBoardCode(int serviceBoardCode) {
		this.serviceBoardCode = serviceBoardCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceReplyContent() {
		return serviceReplyContent;
	}

	public void setServiceReplyContent(String serviceReplyContent) {
		this.serviceReplyContent = serviceReplyContent;
	}

	public String getServiceReplyDate() {
		return serviceReplyDate;
	}

	public void setServiceReplyDate(String serviceReplyDate) {
		this.serviceReplyDate = serviceReplyDate;
	}
	
	
}
