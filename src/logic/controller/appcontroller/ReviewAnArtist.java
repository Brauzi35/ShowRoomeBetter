package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.ReviewBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.ReviewDao;
import logic.engclasses.exceptions.ArtistNotFoundException;
import logic.engclasses.exceptions.DuplicateReviewException;
import logic.model.Artist;
import logic.model.Review;


public class ReviewAnArtist {

	public List<ReviewBean> getReviews(String username) throws ArtistNotFoundException {
		List<ReviewBean> lrb1 = new ArrayList<>();
		ArtistDao ad1 = new ArtistDao();
		Artist a1 = ad1.getArtist(username);
		ReviewDao rd1 = new ReviewDao();
		List<Review> lr1 = rd1.getReview(a1.getUsername());
		
		if(lr1==null) {
			//if there are no reviews referred to the artist
			return lrb1;
		}
		
		for(int i = 0; i < lr1.size(); i++) {
			ReviewBean x = new ReviewBean();
			Review review = lr1.get(i);
			x.setArtist(review.getArtist());
			x.setAuthor(review.getAuthor());
			x.setReview(review.getReview());
			lrb1.add(x);//building reviewBean list
		}
		return lrb1;
	}
	
	public void saveReview(String user, String artist, String review) throws DuplicateReviewException {
		//get the string "author" from the singleton class
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(artist);
		//these 2 lines check if the artist exist in the database
		ReviewDao rd = new ReviewDao();
		rd.submitReview(user, a.getUsername(), review);
	}
	
}
