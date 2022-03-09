package kosta.mvc.dto;

public class LikedArtDTO {
	private int likedCode;
	private String id;
	private int aucCode;
	
	public LikedArtDTO() {}
	
	private ArtDTO artDTO;
	
	public LikedArtDTO(int likedCode, String id, int aucCode) {
		super();
		this.likedCode = likedCode;
		this.id = id;
		this.aucCode = aucCode;
	}
	

	public ArtDTO getArtDTO() {
		return artDTO;
	}


	public void setArtDTO(ArtDTO artDTO) {
		this.artDTO = artDTO;
	}


	public int getLikedCode() {
		return likedCode;
	}

	public void setLikedCode(int likedCode) {
		this.likedCode = likedCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAucCode() {
		return aucCode;
	}

	public void setAucCode(int aucCode) {
		this.aucCode = aucCode;
	}
	
	
	
}
