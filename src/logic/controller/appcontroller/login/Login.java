package logic.controller.appcontroller.login;


import logic.engclasses.bean.ArtistBean;
import logic.engclasses.bean.GeneralUserBean;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.bean.SponsorBean;
import logic.engclasses.dao.ArtistDao;
import logic.engclasses.dao.GeneralUserDao;
import logic.engclasses.dao.SponsorDao;
import logic.engclasses.exceptions.LoginException;
import logic.engclasses.utils.Session;
import logic.model.Artist;
import logic.model.GeneralUser;
import logic.model.Sponsor;



public class Login {

public GeneralUserBean login(String username, String password) throws LoginException{
		
		GeneralUserDao gud = new GeneralUserDao();
		GeneralUser result = gud.login(username, password); //calls the dao login
		if(result==null) {
			throw new LoginException("login ex");
		}
		
		GeneralUserBean gu = new GeneralUserBean();
		
		gu.setUsername(result.getUsername());
		gu.setPassword(result.getPassword());
		gu.setId(result.getId());

		return gu;
	}
	
	public ArtistBean artistLogin(String username, String password) throws LoginException{
		
		ArtistDao ad = new ArtistDao();
		Artist result = ad.artistLogin(username, password);
		if(result==null) {
			throw new LoginException("wrong username and/or password");
		}
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
	
	
	
	public Session setupCredentials(int id, String username, String password) throws LoginException{
		LoggedBean s = new LoggedBean();
		if(id==1) {
			this.login(username, password);
			}
		if(id==2) {
			ArtistBean ab = this.artistLogin(username, password);
			s.setDescription(ab.getDescription());
			s.setTalent(ab.getTalent());
			s.setEmail(ab.getEmail());
		}
		if(id==3) {
			SponsorBean sb = this.sponsorLogin(username, password);
			s.setDescription(sb.getDescription());
			s.setActivity(sb.getActivity());
			s.setCapacity(sb.getCapacity());
			
		}
		s.setId(id);
		s.setUsername(username);
		s.setPassword(password);
		return (new Session(s,id));
		
	}
	
}
