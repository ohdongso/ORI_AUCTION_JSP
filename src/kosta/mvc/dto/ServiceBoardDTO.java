package kosta.mvc.dto;

public class ServiceBoardDTO {
	
	private int serviceBoardCode;
	private String id;
	private String serviceBoardTitle;
	private String serviceBoardContent;
	private int serviceBoardCategory;
	private String serviceBoardDate;
	private int serviceBoardState;
	private ServiceBoardReplyDTO reply;
	
	public  ServiceBoardDTO (){}

	public ServiceBoardDTO(int serviceBoardCode, String id, String serviceBoardTitle, String serviceBoardContent,
			int serviceBoardCategory, String serviceBoardDate, int serviceBoardState) {
		super();
		this.serviceBoardCode = serviceBoardCode;
		this.id = id;
		this.serviceBoardTitle = serviceBoardTitle;
		this.serviceBoardContent = serviceBoardContent;
		this.serviceBoardCategory = serviceBoardCategory;
		this.serviceBoardDate = serviceBoardDate;
		this.serviceBoardState = serviceBoardState;
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

	public String getServiceBoardTitle() {
		return serviceBoardTitle;
	}

	public void setServiceBoardTitle(String serviceBoardTitle) {
		this.serviceBoardTitle = serviceBoardTitle;
	}

	public String getServiceBoardContent() {
		return serviceBoardContent;
	}

	public void setServiceBoardContent(String serviceBoardContent) {
		this.serviceBoardContent = serviceBoardContent;
	}

	public int getServiceBoardCategory() {
		return serviceBoardCategory;
	}

	public void setServiceBoardCategory(int serviceBoardCategory) {
		this.serviceBoardCategory = serviceBoardCategory;
	}

	public String getServiceBoardDate() {
		return serviceBoardDate;
	}

	public void setServiceBoardDate(String serviceBoardDate) {
		this.serviceBoardDate = serviceBoardDate;
	}

	public int getServiceBoardState() {
		return serviceBoardState;
	}

	public void setServiceBoardState(int serviceBoardState) {
		this.serviceBoardState = serviceBoardState;
	}

	public ServiceBoardReplyDTO getReply() {
		return reply;
	}

	public void setReply(ServiceBoardReplyDTO reply) {
		this.reply = reply;
	}
	
}
