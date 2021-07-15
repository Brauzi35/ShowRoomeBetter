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



public class ViewReviews {

	public List<ReviewBean> getReviews(String username) throws ArtistNotFoundException{
		List<ReviewBean> lrb = new ArrayList<>();
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(username);
		ReviewDao rd = new ReviewDao();
		List<Review> lr = rd.getReview(a.getUsername());
		
		if(lr==null) {
			//if there are no reviews referred to the artist
			return lrb;
		}
		
		for(int i = 0; i < lr.size(); i++) {
			ReviewBean x = new ReviewBean();
			Review review = lr.get(i);
			x.setArtist(review.getArtist());
			x.setAuthor(review.getAuthor());
			x.setReview(review.getReview());
			lrb.add(x);//building reviewBean list
		}
		return lrb;
	}
	
	public void saveReview(String usnm, String artist, String review) throws DuplicateReviewException {
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(artist);
		//these 2 lines check if the artist exist in the database
		ReviewDao rd = new ReviewDao();
		rd.submitReview(usnm, a.getUsername(), review);
	}
	
}
