package test;
//Brauzi Valerio
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.controller.appcontroller.login.Register;
import logic.engclasses.exceptions.DuplicateUsernameException;



public class TestRegistration1 {
	@Test
	public void testRegistrationDuplicateUsername(){
		Register rac = new Register();
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