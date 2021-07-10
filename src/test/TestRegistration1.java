package test;
//Brauzi Valerio
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.appcontroller.RegistrationAppController;
import logic.exceptions.DuplicateUsernameException;

public class TestRegistration1 {
	@Test
	public void testRegistrationDuplicateUsername(){
		RegistrationAppController rac = new RegistrationAppController();
		boolean duplicateUsername = false;
		//the user valerio already exists
		try {
			rac.userReg("valerio", "password");
		} catch (DuplicateUsernameException e) {
			duplicateUsername=true;
		}
		assertEquals(true, duplicateUsername);
	}
	
}