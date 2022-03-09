package kosta.mvc.dto;

public class ArtDTO {
	
	private int artCode;
	private String id;
	private int artistCode;
	private String artName;
	private String artistName;
	private int artCategory;
	private int artState;
	private int artSizeHeight;
	private int artSizeWidth;
	private int artSizeVol;
	private int estimateCost;
	private String prdYear;
	private String artDetail;
	private String artImg;
	
	public ArtDTO() { }

	//평변 작품(회화, 사진) 생성자
	public ArtDTO(int artCode, String id, String artName, String artistName, int artCategory,
			int artState, int artSizeHeight, int artSizeWidth, int estimateCost, String prdYear,
			String artDetail, String artImg) {
		this.artCode = artCode;
		this.id = id;
		this.artName = artName;
		this.artistName = artistName;
		this.artCategory = artCategory;
		this.artState = artState;
		this.artSizeHeight = artSizeHeight;
		this.artSizeWidth = artSizeWidth;
		this.estimateCost = estimateCost;
		this.prdYear = prdYear;
		this.artDetail = artDetail;
		this.artImg = artImg;
	}

	//입체작품(공예, 조각) 생성자
	public ArtDTO(int artCode, String id, String artName, String artistName, int artCategory,
			int artState, int artSizeHeight, int artSizeWidth, int artSizeVol, int estimateCost, String prdYear,
			String artDetail, String artImg) {
		this(artCode,id,artName,artistName,artCategory,artState,artSizeHeight,artSizeWidth,estimateCost,prdYear,artDetail,artImg);
		this.artSizeVol = artSizeVol;
	}

	public int getArtCode() {
		return artCode;
	}

	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(int artistCode) {
		this.artistCode = artistCode;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getArtCategory() {
		return artCategory;
	}

	public void setArtCategory(int artCategory) {
		this.artCategory = artCategory;
	}

	public int getArtState() {
		return artState;
	}

	public void setArtState(int artState) {
		this.artState = artState;
	}

	public int getArtSizeHeight() {
		return artSizeHeight;
	}

	public void setArtSizeHeight(int artSizeHeight) {
		this.artSizeHeight = artSizeHeight;
	}

	public int getArtSizeWidth() {
		return artSizeWidth;
	}

	public void setArtSizeWidth(int artSizeWidth) {
		this.artSizeWidth = artSizeWidth;
	}

	public int getArtSizeVol() {
		return artSizeVol;
	}

	public void setArtSizeVol(int artSizeVol) {
		this.artSizeVol = artSizeVol;
	}

	public int getEstimateCost() {
		return estimateCost;
	}

	public void setEstimateCost(int estimateCost) {
		this.estimateCost = estimateCost;
	}

	public String getPrdYear() {
		return prdYear;
	}

	public void setPrdYear(String prdYear) {
		this.prdYear = prdYear;
	}

	public String getArtDetail() {
		return artDetail;
	}

	public void setArtDetail(String artDetail) {
		this.artDetail = artDetail;
	}

	public String getArtImg() {
		return artImg;
	}

	public void setArtImg(String artImg) {
		this.artImg = artImg;
	}

	
	
}
