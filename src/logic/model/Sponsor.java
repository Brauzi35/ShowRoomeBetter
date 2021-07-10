package logic.model;

public class Sponsor {
	private String usernameEntity;
	private String passwordEntity;
	private String activityEntity;
	private String capacityEntity;
	private String descriptionEntity;
	
	public Sponsor(String username, String password, String activity, String capacity, String description) {
		super();
		this.usernameEntity = username;
		this.passwordEntity = password;
		this.activityEntity = activity;
		this.capacityEntity = capacity;
		this.descriptionEntity = description;
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

	public String getActivity() {
		return activityEntity;
	}

	public void setActivity(String activity) {
		this.activityEntity = activity;
	}

	public String getCapacity() {
		return capacityEntity;
	}

	public void setCapacity(String capacity) {
		this.capacityEntity = capacity;
	}

	public String getDescription() {
		return descriptionEntity;
	}

	public void setDescription(String description) {
		this.descriptionEntity = description;
	}
	
	
}
