package test;
//Gianmattia Mignone
import logic.dao.ArtistDao;
import logic.entity.Artist;


import static org.junit.Assert.*;

import org.junit.Test;

public class EmailTest {

	@Test
	public void test() {

	ArtistDao artistdao = new  ArtistDao();
	Artist check = artistdao.getArtist("Scintilla Nuvolini");
    assertEquals("scintilla@email.it",check.getEmail());

	
	}

}
