package logic.controller.appcontroller;

import logic.engclasses.bean.EventBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.EventDao;
import logic.engclasses.dao.PlaceDao;
import logic.engclasses.utils.SessionArtist;
import logic.engclasses.utils.SessionUser;
import logic.model.Event;

public class ViewProfile {

	public EventBean getLiveEvent() {
		EventBean eb = new EventBean();
		EventDao ed = new EventDao();
		SessionArtist sa = SessionArtist.getInstance();
		Event e=ed.getEvent(sa.getUsername()); //get artist from the singleton class which is built during the login
		if(e!=null) {
			eb.setArtist(e.getArtist());
			eb.setDescription(e.getDescription());
			eb.setName(e.getName());
			eb.setPlace(e.getPlace());
			return eb;
		}
		else {return null;}
	}
	
	public EventBean getLiveEventWeb() {
		EventBean eb = new EventBean();
		EventDao ed = new EventDao();
		SessionUser sa = SessionUser.getInstance();
		Event e=ed.getEvent(sa.getUsername()); //get artist from the singleton class which is built during the login
		if(e!=null) {
			eb.setArtist(e.getArtist());
			eb.setDescription(e.getDescription());
			eb.setName(e.getName());
			eb.setPlace(e.getPlace());
			return eb;
		}
		else {return null;}
	}
	
	public void dismissLiveShow() {
		//to delete the current show the system needs to gather the artist's username, delete the row in the db and update the "free" field in the right row of the table "places"
		String artist;
		SessionArtist sa = SessionArtist.getInstance();
		artist=sa.getUsername();
		EventDao ed = new EventDao();
		Event e = ed.getEvent(artist);
		ed.deleteLiveEvent(e.getName());
		PlaceDao pd = new PlaceDao();
		pd.setBooked(e.getPlace(), ""); 
	}
	
	public void updateProfile(String email, String talent, String description) {
		//saves the changes to the artist profile
		SessionArtist sa = SessionArtist.getInstance();
		ArtistDao ad = new ArtistDao();
		ad.updateArtist(sa.getUsername(), email, talent, description);
	}
	
}
