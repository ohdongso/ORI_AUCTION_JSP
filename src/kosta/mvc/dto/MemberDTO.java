package kosta.mvc.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String account;
	private String addr;
	private String contact;
	private String email;
	private int memState;
	private String registDate;
	
	public MemberDTO(){}

	public MemberDTO(String id, String pw, String name, String account, String addr, String contact, String email,
			int memState, String registDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.account = account;
		this.addr = addr;
		this.contact = contact;
		this.email = email;
		this.memState = memState;
		this.registDate = registDate;
	}
	
	/**
	 * 로그인 할때 필요한 생성자
	 */
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	/**
	 * 로그인 할때 필요한 생성자2
	 */
	public MemberDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	
	/**
	 * 회원정보 수정할 때 필요한 생성자
	 */
	public MemberDTO(String id, String pw, String account, String addr, String contact, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.account = account;
		this.addr = addr;
		this.contact = contact;
		this.email = email;
	}
	
	/**
	 * 회원조회할 때 필요한 생성자(관리자)
	 */
	public MemberDTO(String id, String name, String account, String addr, String contact, String email, int memState,
			String registDate) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.addr = addr;
		this.contact = contact;
		this.email = email;
		this.memState = memState;
		this.registDate = registDate;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMemState() {
		return memState;
	}

	public void setMemState(int memState) {
		this.memState = memState;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	
	
}
