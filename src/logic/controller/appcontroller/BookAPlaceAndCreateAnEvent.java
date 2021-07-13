package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.EventBean;
import logic.engclasses.bean.PlaceBean;
import logic.engclasses.dao.EventDao;
import logic.engclasses.dao.PlaceDao;
import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.engclasses.exceptions.EmptyFieldException;
import logic.model.Event;
import logic.model.Place;



public class BookAPlaceAndCreateAnEvent {
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
		
		public List<PlaceBean> freePlaces(){
			List<PlaceBean> lpb = new ArrayList<>();
			PlaceDao pd = new PlaceDao();
			List<Place> lp = pd.getFreePlacesDao();
			
			for(int i = 0; i < lp.size(); i++) {
				PlaceBean x = new PlaceBean();
				Place place = lp.get(i);
				x.setAddress(place.getAddress());
				x.setCapacity(place.getCapacity());
				x.setName(place.getName());
				x.setFree(place.isFree());
				lpb.add(x);//building eventBean list
			}
			return lpb;
		}
		
		public void submitEvent(String artist, String name, String place, String description) throws EmptyFieldException, DescriptionTooLongException {
			if(name.equals("") || description.equals("")) {
				throw new EmptyFieldException("fill both description and title field");
			}
			
			EventDao ed = new EventDao();
			ed.newEvent(name, artist, description, place);
			
			//is necessary to update de free value in the "places" table
			PlaceDao pd = new PlaceDao();
			pd.setBooked(place, artist);
		}
}
