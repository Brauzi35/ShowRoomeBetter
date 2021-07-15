package logic.controller.appcontroller;

import logic.engclasses.bean.EventBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.EventDao;
import logic.engclasses.dao.PlaceDao;
import logic.model.Event;

public class ViewProfile {

	public EventBean getLiveEvent(String username) {
		EventBean eb = new EventBean();
		EventDao ed = new EventDao();
		Event e=ed.getEvent(username); //get artist from the singleton class which is built during the login
		if(e!=null) {
			eb.setArtist(e.getArtist());
			eb.setDescription(e.getDescription());
			eb.setName(e.getName());
			eb.setPlace(e.getPlace());
			return eb;
		}
		else {return null;}
	}
	
	public EventBean getLiveEventWeb(String uname) {
		EventBean eb = new EventBean();
		EventDao ed = new EventDao();
		Event e=ed.getEvent(uname); //get artist from the singleton class which is built during the login
		if(e!=null) {
			eb.setArtist(e.getArtist());
			eb.setDescription(e.getDescription());
			eb.setName(e.getName());
			eb.setPlace(e.getPlace());
			return eb;
		}
		else {return null;}
	}
	
	public void dismissLiveShow(String username) {
		//to delete the current show the system needs to gather the artist's username, delete the row in the db and update the "free" field in the right row of the table "places"
		
		EventDao ed = new EventDao();
		Event e = ed.getEvent(username);
		ed.deleteLiveEvent(e.getName());
		PlaceDao pd = new PlaceDao();
		pd.setBooked(e.getPlace(), ""); 
	}
	
	public void updateProfile(String usernm, String email, String talent, String description) {
		//saves the changes to the artist profile
		ArtistDao ad = new ArtistDao();
		ad.updateArtist(usernm, email, talent, description);
	}
	
}
