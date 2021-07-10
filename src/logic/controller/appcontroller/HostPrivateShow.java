package logic.controller.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.engclasses.bean.RequestedShowBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.RequestsDao;
import logic.engclasses.dao.SponsorDao;
import logic.engclasses.dao.SponsoredShowDao;
import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.engclasses.utils.SessionSponsor;

import logic.model.Artist;
import logic.model.RequestedShow;
import logic.model.Sponsor;
import logic.model.SponsoredShow;



public class HostPrivateShow {

	public List<String> buildArtistStringArray(){
		//this method builds the array needed for a listView gathering each free artist that can be contcted
		List<String> artists = new ArrayList<>();
		ArtistDao ad = new ArtistDao();
		List<Artist> la = ad.getArtists();
		for(int i = 0; i < la.size(); i++) {
			String x = la.get(i).getUsername();
			artists.add(x);//building reviewBean list
		}
		
		return artists;
	}
	
	public String getDescription(String artist){
		String description;
		ArtistDao ad = new ArtistDao();
		description = ad.getArtist(artist).getDescription();
		return description;
		
	}
	
	public List<String> buildSponsorStringArray(){
		//this method provides a string array which contains every sponsor username except for the sessionSponsor's one
		List<String> sponsors = new ArrayList<>();
		SponsorDao sd = new SponsorDao();
		List<Sponsor> la = sd.getSponsors();
		for(int i = 0; i < la.size(); i++) {
			String x = la.get(i).getUsername();
			sponsors.add(x);//building reviewBean list
		}
		//given the full list now the sessionSponsor username has to be removed
		SessionSponsor instance = SessionSponsor.getInstance();
		sponsors.remove(instance.getUsername());
		
		return sponsors;
		
	}
	
	public RequestedShowBean getPendingRequest() {
		RequestedShowBean result = new RequestedShowBean();
		RequestsDao rd = new RequestsDao();
		RequestedShow rs = rd.getQueuedShow();
		if(rs!=null) {
			result.setHost(rs.getHost());
			result.setTitle(rs.getTitle());
			result.setArtist(rs.getArtist());
			result.setPartner(rs.getPartner());
			result.setDescription(rs.getDescription());
			result.setApprovedArtist(rs.getApprovedArtist());
			result.setApprovedPartner(rs.getApprovedPartner());
			return result;
		}
		else {
			return null;
		}
	}
	
	public void hostSponsoredShow(String title, String artist, String sponsor, String location, String capacity, String partner, String description) {
		SponsoredShow ss = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
		SponsoredShowDao ssd = new SponsoredShowDao();
		try {
			ssd.hostSponsoredShow(ss);
		} catch (DescriptionTooLongException e) {
			//implementare controllo errore
			e.printStackTrace();
		}
		this.deleteRequest();
	}
	
	public void deleteRequest() {
		RequestsDao rd = new RequestsDao();
		rd.deleteRequest();
	}
	
}
