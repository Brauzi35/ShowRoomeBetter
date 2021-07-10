package logic.engclasses.bean;

public class EventBean {
	private String nameBean;
	private String artistBean;
	private String descriptionBean;
	private String placeBean;
	
	public String getName() {
		return nameBean;
	}

	public void setName(String name) {
		this.nameBean = name;
	}

	public String getArtist() {
		return artistBean;
	}

	public void setArtist(String artist) {
		this.artistBean = artist;
	}

	public String getDescription() {
		return descriptionBean;
	}

	public void setDescription(String description) {
		this.descriptionBean = description;
	}

	public String getPlace() {
		return placeBean;
	}

	public void setPlace(String place) {
		this.placeBean = place;
	}
}
