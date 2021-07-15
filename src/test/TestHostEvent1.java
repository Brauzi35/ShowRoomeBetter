package test;
//Brauzi Valerio

import logic.controller.appcontroller.BookAPlaceAndCreateAnEvent;
import logic.controller.appcontroller.login.Login;
import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.engclasses.exceptions.EmptyFieldException;
import logic.engclasses.exceptions.LoginException;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

public class TestHostEvent1 {

	@Test
	public void testStartEvent() throws LoginException {
		//forced login necessary for testing artist functions 
		Login lc = new Login();
		lc.artistLogin("meo", "password");
		BookAPlaceAndCreateAnEvent mc = new BookAPlaceAndCreateAnEvent();
		boolean emptyField= false;
		try {
			//meo is trying to submit an event without writing any title
			mc.submitEvent("meo" ,"", "Villa", "desc");
		} catch (EmptyFieldException e) {
			emptyField = true;
		} catch (DescriptionTooLongException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, emptyField);
		
	}
	
}
