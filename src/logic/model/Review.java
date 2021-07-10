package logic.model;

public class Review {
//aims to associate each review to both an aritst and the author
	String author;
	String artist;
	String rev; //A field should not duplicate the name of its containing class rev=review
	
	public Review(String author, String artist, String review) {
		super();
		this.author = author;
		this.artist = artist;
		this.rev = review; 
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getReview() {
		return rev;
	}

	public void setReview(String review) {
		this.rev = review;
	}

	
}
