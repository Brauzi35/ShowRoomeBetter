package test;
//Gianmattia Mignone



import static org.junit.Assert.*;

import org.junit.Test;

import logic.engclasses.dao.ArtistDao;
import logic.model.Artist;

public class EmailTest {

	@Test
	public void test() {

	ArtistDao artistdao = new  ArtistDao();
	Artist check = artistdao.getArtist("Scintilla Nuvolini");
    assertEquals("scintilla@email.it",check.getEmail());

	
	}

}
