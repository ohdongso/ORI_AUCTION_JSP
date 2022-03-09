package kosta.mvc.dto;

public class ArtistDTO {
	private int artistCode;
	private String id;
	private String artistImg;
	private String career;
	private String artistDetail;
	private String profileLink;
	
	public ArtistDTO() {}
	
	/**
	 * member객체를 생성해서 artist에서 member의 정보를 가져올 수 있다.
	 */
	private MemberDTO member;

	public ArtistDTO(int artistCode, String id, String artistImg, String career, String artistDetail,
			String profileLink) {
		super();
		this.artistCode = artistCode;
		this.id = id;
		this.artistImg = artistImg;
		this.career = career;
		this.artistDetail = artistDetail;
		this.profileLink = profileLink;
	}
	
	/**
	 * 정보 수정시 필요한 생성자
	 */
	public ArtistDTO(String id, String career, String artistDetail, String profileLink) {
		super();
		this.id = id;
		this.career = career;
		this.artistDetail = artistDetail;
		this.profileLink = profileLink;
	}
	

	public MemberDTO getMember() {
		return member;
	}


	public void setMember(MemberDTO member) {
		this.member = member;
	}



	public int getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(int artistCode) {
		this.artistCode = artistCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArtistImg() {
		return artistImg;
	}

	public void setArtistImg(String artistImg) {
		this.artistImg = artistImg;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getArtistDetail() {
		return artistDetail;
	}

	public void setArtistDetail(String artistDetail) {
		this.artistDetail = artistDetail;
	}

	public String getProfileLink() {
		return profileLink;
	}

	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}
	
	
	
}
