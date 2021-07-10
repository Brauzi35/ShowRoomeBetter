package logic.controller.appcontroller;

import logic.engclasses.dao.SponsoredShowDao;

public class EditCommercialActivity {

	public void delete() {
		SponsoredShowDao ssd = new SponsoredShowDao();
		ssd.dismissShow();
	}
	
}
