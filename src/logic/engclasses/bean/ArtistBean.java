package logic.engclasses.bean;

public class ArtistBean {
	private String usernameBean;
	private String passwordBean;
	private String emailBean;
	private String descriptionBean;
	private String talentBean;
	
	public String getUsername() {
		return usernameBean;
	}
	
	public void setUsername(String username) {
		this.usernameBean = username;
	}
	
	public String getPassword() {
		return passwordBean;
	}

	public void setPassword(String password) {
		this.passwordBean = password;
	}

	public String getEmail() {
		return emailBean;
	}

	public void setEmail(String email) {
		this.emailBean = email;
	}

	public String getDescription() {
		return descriptionBean;
	}

	public void setDescription(String description) {
		this.descriptionBean = description;
	}

	public String getTalent() {
		return talentBean;
	}

	public void setTalent(String talent) {
		this.talentBean = talent;
	}
}
