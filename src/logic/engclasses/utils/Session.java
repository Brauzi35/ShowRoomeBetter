package logic.engclasses.utils;

import logic.engclasses.bean.LoggedBean;

public class Session {

	private LoggedBean loggedbean;
	private int id;
	public Session(LoggedBean loggedbean, int id) {
		this.loggedbean = loggedbean;
		this.id = id;
	}
	
	public LoggedBean getLoggedBean() {
		return loggedbean;
	}
	
	public int getId() {
		return id;
	}
	
}
