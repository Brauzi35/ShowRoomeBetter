package logic.model;

public class Event {
//an event is a show or a performance made by an artist; every event is associated to a place through name
	private String name;
	private String artist;
	private String description;
	private String place;
	
	public Event(String name, String artist, String description, String place) {
		super();
		this.name = name;
		this.artist = artist;
		this.description = description;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
}
