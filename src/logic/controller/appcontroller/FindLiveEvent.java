package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.EventBean;
import logic.engclasses.dao.EventDao;
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
	
}
