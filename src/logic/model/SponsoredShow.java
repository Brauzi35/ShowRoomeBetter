package logic.model;

public class SponsoredShow {
	//this kind of shows can only be created by sponsors
	String title;
	String artist;
	String sponsor;
	String location;
	String capacity;
	String partner;
	String description;
	
	public SponsoredShow(String title, String artist, String sponsor, String location, String capacity, String partner,
			String description) {
		super();
		this.title = title;
		this.artist = artist;
		this.sponsor = sponsor;
		this.location = location;
		this.capacity = capacity;
		this.partner = partner;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
