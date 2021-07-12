package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.ArtistBean;
import logic.engclasses.bean.EventBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.EventDao;
import logic.model.Artist;
import logic.model.Event;



public class FindLiveEvent {

	//application controller to pass an array list to the graphic controller
		//convert list<event> in list<eventBean>
		public List<EventBean> liveEventsList(){
			List<EventBean> leb2 = new ArrayList<>();//return value
			EventDao ed = new EventDao();
			List<Event> le = ed.getLiveEvents();
			
			for(int i = 0; i < le.size(); i++) {
				EventBean c = new EventBean();
				Event event = le.get(i);
				c.setArtist(event.getArtist());
				c.setDescription(event.getDescription());
				c.setName(event.getName());
				c.setPlace(event.getPlace());
				leb2.add(c);//building eventBean list
			}
			
			return leb2;
		}
	
		public ArtistBean getArtist(String name) {
			  ArtistDao ad = new ArtistDao();
			  ArtistBean ab = new ArtistBean();
			  Artist a = ad.getArtist(name);
			  
			  ab.setUsername(name);
			  ab.setTalent(a.getTalent());
			  ab.setPassword(a.getPassword());
			  ab.setEmail(a.getEmail());
			  ab.setDescription(a.getDescription());
			  return ab;
		  }
}
