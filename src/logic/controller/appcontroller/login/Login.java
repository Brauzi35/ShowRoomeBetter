package logic.controller.appcontroller.login;


import logic.engclasses.bean.ArtistBean;
import logic.engclasses.bean.GeneralUserBean;
import logic.engclasses.bean.SponsorBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.GeneralUserDao;
import logic.engclasses.dao.SponsorDao;
import logic.engclasses.exceptions.LoginException;
import logic.engclasses.utils.Credentials;
import logic.model.Artist;
import logic.model.GeneralUser;
import logic.model.Sponsor;



public class Login {

public GeneralUserBean login(String username, String password) throws LoginException{
		
		GeneralUserDao gud = new GeneralUserDao();
		GeneralUser result = gud.login(username, password); //calls the dao login
		
		
		GeneralUserBean gu = new GeneralUserBean();
		
		gu.setUsername(result.getUsername());
		gu.setPassword(result.getPassword());
		gu.setId(result.getId());

		return gu;
	}
	
	public ArtistBean artistLogin(String username, String password){
		
		ArtistDao ad = new ArtistDao();
		Artist result = ad.artistLogin(username, password);
		
		ArtistBean ab = new ArtistBean();
		ab.setUsername(result.getUsername());
		ab.setPassword(result.getPassword());
		ab.setTalent(result.getTalent());
		ab.setEmail(result.getEmail());
		ab.setDescription(result.getDescription());
		return ab;
		
	}
	
	public SponsorBean sponsorLogin(String username, String password) throws LoginException{
		SponsorDao sd = new SponsorDao();
		Sponsor result = sd.loginSponsor(username, password);
		if(result==null) {
			throw new LoginException("wrong username and/or password");
		}
		SponsorBean sb = new SponsorBean();
		sb.setUsername(result.getUsername());
		sb.setPassword(result.getPassword());
		sb.setActivity(result.getActivity());
		sb.setCapacity(result.getCapacity());
		sb.setDescription(result.getDescription());
		return sb;
	}
	
	
	
	public void setupCredentials(int id, String username, String password) throws LoginException{
		Credentials c = Credentials.getInstance();
		if(id==1) {this.login(username, password);}
		if(id==2) {
			ArtistBean ab = this.artistLogin(username, password);
			c.setDescription(ab.getDescription());
			c.setTalent(ab.getTalent());
			c.setEmail(ab.getEmail());
		}
		if(id==3) {
			SponsorBean sb = this.sponsorLogin(username, password);
			c.setDescription(sb.getDescription());
			c.setActivity(sb.getActivity());
			c.setCapacity(sb.getCapacity());
			
		}
		c.setId(id);
		c.setUsername(username);
		c.setPassword(password);
	}
	
}
