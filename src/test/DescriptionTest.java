package test;
//Gianmattia Mignone
import static org.junit.Assert.*;

import org.junit.Test;

import   logic.bean.RequestedShowBean;

public class DescriptionTest {

	@Test
	public void chechdescriptionshow() {
		RequestedShowBean check = new RequestedShowBean();
    check.setDescription("Un bravo cantante");
    assertEquals("Un bravo cantante",check.getDescription());

		
		
		
		
	}

}


























