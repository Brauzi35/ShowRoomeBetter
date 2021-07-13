package logic.controller.appcontroller;

import logic.engclasses.dao.SponsoredShowDao;

public class EditCommercialActivity {

	public void delete(String host) {
		SponsoredShowDao ssd = new SponsoredShowDao();
		ssd.dismissShow(host);
	}
	
}
