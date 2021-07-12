package test;
//Gianmattia Mignone
import static org.junit.Assert.*;
import org.junit.Test;

import logic.controller.appcontroller.login.Login;
import logic.engclasses.bean.ArtistBean;
import logic.engclasses.exceptions.LoginException;
public class  LoginArtist {

	@Test
   public	void test() throws LoginException, javax.security.auth.login.LoginException   {
		Login loginController = new Login();
		ArtistBean check = loginController.artistLogin("meo","password");
      assertEquals("mimo",check. getTalent());
	}

}









