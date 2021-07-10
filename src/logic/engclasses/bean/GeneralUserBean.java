package logic.engclasses.bean;



public class GeneralUserBean {
	
	static final long serialVersionUID = 42L;
	
	protected String username;
	protected String password;
	protected int id;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
	
}
