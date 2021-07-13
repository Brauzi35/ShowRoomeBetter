package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.RequestedShowBean;
import logic.engclasses.bean.SponsorBean;
import logic.engclasses.dao.RequestsDao;
import logic.engclasses.dao.SponsorDao;
import logic.model.RequestedShow;
import logic.model.Sponsor;



public class CheckPersonalMessages {

	public List<String> buildRequestsStringArray(String artist){
		//this method builds the array needed for a listView gathering each pending request
		List<String> requests = new ArrayList<>();
		RequestsDao rd = new RequestsDao();
		List<RequestedShow> ls = rd.getRequests(artist);
		if(ls == null) {
			//if there are no requests
			return requests;
		}
		for(int i = 0; i < ls.size(); i++) {
			String x = ls.get(i).getTitle();
			requests.add(x);//building reviewBean list
		}
		
		return requests;
	}
	
	public RequestedShowBean getRequestedShowBean(String title) {
		RequestedShowBean rsb=new RequestedShowBean();
		RequestedShow rs;
		
		RequestsDao rd = new RequestsDao();
		rs= rd.getQueuedShowByTitle(title);
		rsb.setHost(rs.getHost());
		rsb.setPartner(rs.getTitle());
		rsb.setTitle(rs.getTitle());
		rsb.setDescription(rs.getDescription());
		rsb.setArtist(rs.getArtist());
		rsb.setApprovedPartner(rs.getApprovedPartner());
		rsb.setApprovedArtist(rs.getApprovedArtist());
		
		return rsb;
		
	}
	
	public SponsorBean getSponsor(String host) {
		SponsorBean sb = new SponsorBean();
		Sponsor s;
		SponsorDao sd = new SponsorDao();
		s= sd.getSponsor(host);
		
		sb.setUsername(host);
		sb.setPassword(s.getPassword());
		sb.setDescription(s.getDescription());
		sb.setCapacity(s.getCapacity());
		sb.setActivity(s.getActivity());
		
		return sb;
		
	}
	
	public void acceptRequest(String title, String state) {
		//this method makes the Request dao change the "approvedArtist" from no to yes
		RequestsDao rd = new RequestsDao();
		rd.updateApprovedArtist(title, state);
	}
	
}
