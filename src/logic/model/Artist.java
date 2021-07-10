package logic.model;
//da rifare in base al database
public class Artist {
	private String usernameEntity;
	private String passwordEntity;
	private String emailEntity;
	private String descriptionEntity;
	private String talentEntity;

	//an artist must give to the system all this informations
	
	public Artist(String username, String password, String email, String description, String talent) {
		super();
		this.usernameEntity = username;
		this.passwordEntity = password;
		this.emailEntity = email;
		this.descriptionEntity = description;
		this.talentEntity = talent;
	}


	public String getUsername() {
		return usernameEntity;
	}
	
	public void setUsername(String username) {
		this.usernameEntity = username;
	}
	
	public String getPassword() {
		return passwordEntity;
	}


	public void setPassword(String password) {
		this.passwordEntity = password;
	}


	public String getEmail() {
		return emailEntity;
	}


	public void setEmail(String email) {
		this.emailEntity = email;
	}


	public String getDescription() {
		return descriptionEntity;
	}


	public void setDescription(String description) {
		this.descriptionEntity = description;
	}


	public String getTalent() {
		return talentEntity;
	}


	public void setTalent(String talent) {
		this.talentEntity = talent;
	}
	
	
}
