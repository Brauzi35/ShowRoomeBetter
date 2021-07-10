package logic.engclasses.utils;

public class SessionSponsor {
	//****Singleton****//
	private static SessionSponsor instance = null;
	
	private SessionSponsor() {}

	public static synchronized SessionSponsor getInstance() {
		if(instance == null)
			instance = new SessionSponsor();
			
		return instance;
	}
	//fine singleton
	
	//attributi
	private String username;
	private String password;
	private String activity;
	private String capacity;
	private String description;
	
	//metodi
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
