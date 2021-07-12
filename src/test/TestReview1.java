package test;
//Brauzi Valerio
import static org.junit.Assert.assertEquals;

import java.util.List;

//Brauzi Valerio
import org.junit.Test;

import logic.controller.appcontroller.ViewReviews;
import logic.engclasses.bean.ReviewBean;
import logic.engclasses.exceptions.ArtistNotFoundException;



public class TestReview1 {
	@Test
	public void testVerifyExistenceReviews() throws ArtistNotFoundException {
		ViewReviews rc = new ViewReviews();
		List<ReviewBean> lrb = rc.getReviews("Flavietta");
		boolean isNotEmpty = false;
		if(!lrb.isEmpty()) {
			isNotEmpty= true;
		}
		assertEquals(true, isNotEmpty);
	}
}
