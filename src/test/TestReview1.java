package test;
import static org.junit.Assert.assertEquals;

import java.util.List;

//Brauzi Valerio
import org.junit.Test;



import logic.appcontroller.ReviewController;
import logic.bean.ReviewBean;

public class TestReview1 {
	@Test
	public void testVerifyExistenceReviews() {
		ReviewController rc = new ReviewController();
		List<ReviewBean> lrb = rc.getReviews("Flavietta");
		boolean isNotEmpty = false;
		if(!lrb.isEmpty()) {
			isNotEmpty= true;
		}
		assertEquals(true, isNotEmpty);
	}
}
