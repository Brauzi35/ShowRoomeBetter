package test;
//Brauzi Valerio
import logic.appcontroller.LoginController;
import logic.appcontroller.MapController;
import logic.exceptions.DescriptionTooLongException;
import logic.exceptions.EmptyFieldException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHostEvent1 {

	@Test
	public void testStartEvent() {
		//forced login necessary for testing artist functions 
		LoginController lc = new LoginController();
		lc.artistLogin("meo", "password");
		MapController mc = new MapController();
		boolean emptyField= false;
		try {
			//meo is trying to submit an event without writing any title
			mc.submitEvent("", "Villa", "desc");
		} catch (EmptyFieldException e) {
			emptyField = true;
		} catch (DescriptionTooLongException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, emptyField);
		
	}
	
}
