package logic.model;

public class GeneralUser {
	protected String username;
	protected String password;
	private int id;
	
	public GeneralUser() {
		this.username = "";
		this.password = "";
		this.id = 0;
	}
	
	public GeneralUser(String username, String password, int id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getId() {
		return id;
	}
}
